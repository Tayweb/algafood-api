package com.algaworks.algafood.infrastructure.service.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.domain.model.StatusPedido;
import com.algaworks.algafood.domain.service.VendaQueryService;
import com.algaworks.algafood.dto.VendaDiaria;

@Repository
public class VendaQueryServiceImpl implements VendaQueryService {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<VendaDiaria> consultarVendasDiaria(VendaDiariaFilter filtro, String data) {

		var builder = manager.getCriteriaBuilder();
		var query = builder.createQuery(VendaDiaria.class); // Especifica o tipo de retorno
		var root = query.from(Pedido.class);
		var functionDateCriacao = builder.function("TO_CHAR", String.class, root.get("dataCriacao"),
				builder.literal("dd-MM-yyyy"));

		var selection = builder.construct(VendaDiaria.class, functionDateCriacao, builder.count(root.get("id")),
				builder.sum(root.get("valorTotal")));

		var predicates = new ArrayList<Predicate>();

		if (filtro.getRestauranteId() != null) {
			predicates.add(builder.equal(root.get("restaurante"), filtro.getRestauranteId()));
		}

		if (filtro.getDataCriacaoInicio() != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("dataCriacao"), filtro.getDataCriacaoInicio()));
		}

		if (filtro.getDataCriacaoFim() != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("dataCriacao"), filtro.getDataCriacaoFim()));
		}

		predicates.add(root.get("status").in(StatusPedido.CONFIRMADO, StatusPedido.ENTREGUE));

		query.select(selection);
		query.groupBy(functionDateCriacao);
		query.where(predicates.toArray(new Predicate[0]));
		return manager.createQuery(query).getResultList();
	}

}
