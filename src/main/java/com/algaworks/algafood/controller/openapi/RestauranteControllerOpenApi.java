package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.dto.RestauranteDTO;
import com.algaworks.algafood.dto.input.RestauranteInputDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Gerencia os restaurantes", name = "Restaurantes")
public interface RestauranteControllerOpenApi {

	@Operation(summary = "Lista os restaurantes")
	List<RestauranteDTO> listar();

	@Operation(summary = "Busca um restaurante por ID")
	RestauranteDTO buscarPorId(@Parameter(description = "ID do restaurante", example = "1") Long restauranteId);

	@Operation(summary = "Cadastra um restaurante")
	RestauranteDTO salvar(RestauranteInputDTO restauranteInputDTO);

	@Operation(summary = "Atualiza um restaurante por ID")
	RestauranteDTO atualizar(@Parameter(description = "ID do restaurante", example = "1") Long restauranteId,
			RestauranteInputDTO restauranteInputDTO);

	@Operation(summary = "Ativa um restaurante por ID")
	void ativar(@Parameter(description = "ID do restaurante", example = "1") Long restauranteId);

	@Operation(summary = "Desativa um restaurante por ID")
	void inativar(@Parameter(description = "ID do restaurante", example = "1") Long restauranteId);

	@Operation(summary = "Abre um restaurante por ID")
	void abrir(@Parameter(description = "ID do restaurante", example = "1") Long restauranteId);

	@Operation(summary = "Fecha um restaurante por ID")
	void fechar(@Parameter(description = "ID do restaurante", example = "1") Long restauranteId);

	@Operation(summary = "Ativa vários restaurantes por IDs")
	void ativarMultiplos(List<Long> restaurantesIds);

	@Operation(summary = "Desativa vários restaurantes por IDs")
	void inativarMultiplos(List<Long> restaurantesIds);

}