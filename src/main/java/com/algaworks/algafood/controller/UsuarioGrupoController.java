package com.algaworks.algafood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.assembler.GrupoModelAssembler;
import com.algaworks.algafood.controller.openapi.UsuarioGrupoControllerOpenApi;
import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.domain.service.CadastroUsuarioService;
import com.algaworks.algafood.dto.GrupoDTO;

@RestController
@RequestMapping(value = "/usuarios/{usuarioId}/grupos", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioGrupoController implements UsuarioGrupoControllerOpenApi {

	@Autowired
	private CadastroUsuarioService cadastroUsuario;

	@Autowired
	private GrupoModelAssembler grupoModelAssembler;

	@Override

	@GetMapping
	public List<GrupoDTO> listar(@PathVariable Long usuarioId) {
		Usuario usuario = cadastroUsuario.buscarOuFalhar(usuarioId);

		return grupoModelAssembler.toCollectionModel(usuario.getGrupos());
	}

	@Override

	@DeleteMapping("/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void desassociar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		cadastroUsuario.desassociarGrupo(usuarioId, grupoId);
	}

	@Override

	@PutMapping("/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void associar(@PathVariable Long usuarioId, @PathVariable Long grupoId) {
		cadastroUsuario.associarGrupo(usuarioId, grupoId);
	}
}
