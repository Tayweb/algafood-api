package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.domain.filter.VendaDiariaFilter;
import com.algaworks.algafood.dto.VendaDiaria;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Estátistica de vendas", name = "Estatística")
public interface EstatisticasControllerOpenApi {

	@Operation(summary = "Lista de vendas diárias")
	List<VendaDiaria> consultarVendasDiarias(VendaDiariaFilter filtro, String data);

}