package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.dto.GrupoDTO;
import com.algaworks.algafood.dto.input.GrupoInputDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Grupos", description = "Gerencia os grupos de usuários")
public interface GrupoControllerOpenApi {

	@Operation(summary = "Lista os grupos")
	List<GrupoDTO> listar();

	@Operation(summary = "Busca um grupo por ID")
	GrupoDTO buscar(@Parameter(description = "ID do grupo", example = "1") Long grupoId);

	@Operation(summary = "Cadastra um grupo")
	GrupoDTO adicionar(GrupoInputDTO grupoInput);

	@Operation(summary = "Atualiza um grupo por ID")
	GrupoDTO atualizar(@Parameter(description = "ID do grupo", example = "1") Long grupoId, GrupoInputDTO grupoInput);

	@Operation(summary = "Exclui um grupo por ID")
	void remover(@Parameter(description = "ID do grupo", example = "1") Long grupoId);

}