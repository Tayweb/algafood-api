package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.dto.PermissaoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Gerencia as Permissões do grupo", name = "Grupo Permissão")
public interface GrupoPermissaoControllerOpenApi {

	@Operation(summary = "Lista as permissões do grupo")
	List<PermissaoDTO> listar(@Parameter(description = "ID da permissão", example = "1") Long grupoId);

	@Operation(summary = "Desassocia a permissão de um grupo")
	void desassociar(@Parameter(description = "ID do grupo e ID da permissão", example = "1") Long grupoId,
			Long permissaoId);

	@Operation(summary = "Associa a permissão a um grupo")
	void associar(@Parameter(description = "ID do grupo e ID da permissão", example = "1") Long grupoId,
			Long permissaoId);

}