package com.algaworks.algafood.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Grupo;
import com.algaworks.algafood.dto.input.GrupoInputDTO;

@Component
public class GrupoInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Grupo toDomainObject(GrupoInputDTO grupoInput) {
		return modelMapper.map(grupoInput, Grupo.class);
	}

	public void copyToDomainObject(GrupoInputDTO grupoInput, Grupo grupo) {
		modelMapper.map(grupoInput, grupo);
	}
}