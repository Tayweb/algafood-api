package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.dto.EstadoDTO;
import com.algaworks.algafood.dto.input.EstadoInputDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Gerencia o estado", name = "Estado")
public interface EstadoControllerOpenApi {

	@Operation(summary = "Lista os estados")
	List<EstadoDTO> listar();

	@Operation(summary = "Busca um estado por ID")
	EstadoDTO buscar(@Parameter(description = "ID do estado", example = "1") Long estadoId);

	@Operation(summary = "Adiciona uma estado")
	EstadoDTO adicionar(EstadoInputDTO estadoInput);

	@Operation(summary = "Atualiza um estado por ID")
	EstadoDTO atualizar(@Parameter(description = "ID do estado", example = "1") Long estadoId,
			EstadoInputDTO estadoInput);

	@Operation(summary = "Exclui um estado por ID")
	void excluir(@Parameter(description = "ID do estado", example = "1") Long estadoId);

}