package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.dto.GrupoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Gerencia o grupo do Usuario", name = "Grupo do Usuário")
public interface UsuarioGrupoControllerOpenApi {

	@Operation(summary = "Lista os grupos em que o usuário pertence")
	List<GrupoDTO> listar(Long usuarioId);

	@Operation(summary = "Desassocia o usuário de um grupo")
	void desassociar(@Parameter(description = "ID de grupo e ID do usuário", example = "1") Long usuarioId,
			Long grupoId);

	@Operation(summary = "Associa o usuario a um grupo")
	void associar(@Parameter(description = "ID de grupo e ID do usuário", example = "1") Long usuarioId, Long grupoId);

}