package com.algaworks.algafood.assembler;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Usuario;
import com.algaworks.algafood.dto.input.UsuarioComSenhaInputDTO;
import com.algaworks.algafood.dto.input.UsuarioInputDTO;

@Component
public class UsuarioInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Usuario toDomainObject(@Valid UsuarioComSenhaInputDTO usuarioInput) {
		return modelMapper.map(usuarioInput, Usuario.class);
	}

	public void copyToDomainObject(UsuarioInputDTO usuarioInput, Usuario usuario) {
		modelMapper.map(usuarioInput, usuario);
	}
}