package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.dto.UsuarioDTO;
import com.algaworks.algafood.dto.input.SenhaInputDTO;
import com.algaworks.algafood.dto.input.UsuarioComSenhaInputDTO;
import com.algaworks.algafood.dto.input.UsuarioInputDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Gerencia os usuários", name = "Usuário")
public interface UsuarioControllerOpenApi {

	@Operation(summary = "Lista os usuários")
	public List<UsuarioDTO> listar();

	@Operation(summary = "Busca o usuário por ID")
	public UsuarioDTO buscar(@Parameter(description = "ID de um usuário", example = "1") Long usuarioId);

	@Operation(summary = "Cadastra um usuário")
	public UsuarioDTO adicionar(UsuarioComSenhaInputDTO usuarioInput);

	@Operation(summary = "Atualiza um usuário por ID")
	public UsuarioDTO atualizar(@Parameter(description = "ID de um usuário", example = "1") Long usuarioId,
			UsuarioInputDTO usuarioInput);

	@Operation(summary = "Atualiza a senha de um usuário por ID")
	public void alterarSenha(@Parameter(description = "ID de um usuário", example = "1") Long usuarioId,
			SenhaInputDTO senha);
}
