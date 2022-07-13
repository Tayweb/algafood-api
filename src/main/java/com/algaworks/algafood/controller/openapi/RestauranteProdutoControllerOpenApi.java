package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.dto.ProdutoDTO;
import com.algaworks.algafood.dto.input.ProdutoInputDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Produtos", name = "gerencia os produtos de restaurantes")
public interface RestauranteProdutoControllerOpenApi {

	@Operation(summary = "lista os produtos de um restaurantes")
	List<ProdutoDTO> listar(Long restauranteId, boolean incluirInativos);

	@Operation(summary = "Busca um produto de um restaurante")
	ProdutoDTO buscar(@Parameter(description = "ID do restaurante e ID de produto", example = "1") Long restauranteId,
			Long produtoId);

	@Operation(summary = "Cadastra um produto de restaurante")
	ProdutoDTO adicionar(@Parameter(description = "ID do restaurante ", example = "1") Long restauranteId,
			ProdutoInputDTO produtoInput);

	@Operation(summary = "Atualiza um produto de um restaurante")
	ProdutoDTO atualizar(@Parameter(description = "ID do restaurante ", example = "1") Long restauranteId,
			Long produtoId, ProdutoInputDTO produtoInput);

}