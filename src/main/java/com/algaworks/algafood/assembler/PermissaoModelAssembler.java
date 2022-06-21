package com.algaworks.algafood.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.dto.PermissaoDTO;

@Component
public class PermissaoModelAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public PermissaoDTO toModel(Permissao permissao) {
		return modelMapper.map(permissao, PermissaoDTO.class);
	}

	public List<PermissaoDTO> toCollectionModel(Collection<Permissao> permissoes) {
		return permissoes.stream().map(permissao -> toModel(permissao)).collect(Collectors.toList());
	}

}