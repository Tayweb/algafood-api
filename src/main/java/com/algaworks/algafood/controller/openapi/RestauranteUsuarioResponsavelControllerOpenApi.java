package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.dto.UsuarioDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

public interface RestauranteUsuarioResponsavelControllerOpenApi {

	@Operation(summary = "Lista os usuários responsáveis associados a restaurante")
	List<UsuarioDTO> listar(Long restauranteId);

	@Operation(summary = "Desassociação de restaurantes com usuário responsável")
	void desassociar(@Parameter(description = "ID do restaurante e ID do usuário", example = "1") Long restauranteId,
			Long usuarioId);

	@Operation(summary = "Associação de restaurantes com usuário responsável")
	void associar(@Parameter(description = "ID do restaurante e ID do usuário", example = "1") Long restauranteId,
			Long usuarioId);

}