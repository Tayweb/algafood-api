package com.algaworks.algafood.controller.openapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

import com.algaworks.algafood.dto.FotoProdutoDTO;
import com.algaworks.algafood.dto.input.FotoProdutoInputDTO;

import io.swagger.v3.oas.annotations.Operation;

public interface RestauranteProdutoFotoControllerOpenApi {

	@Operation(summary = "Atualiza foto do produto")
	FotoProdutoDTO atualizarFoto(Long restauranteId, Long produtoId, FotoProdutoInputDTO fotoProdutoInputDTO)
			throws Exception;

	@Operation(summary = "Busca uma foto do produto")
	FotoProdutoDTO buscar(Long restauranteId, Long produtoId);

	ResponseEntity<?> servirFoto(Long restauranteId, Long produtoId, String acceptHeader)
			throws HttpMediaTypeNotAcceptableException;

	@Operation(summary = "Exclui uma foto do produto")
	void excluir(Long restauranteId, Long produtoId);

}