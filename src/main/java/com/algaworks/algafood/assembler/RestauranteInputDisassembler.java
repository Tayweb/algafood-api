package com.algaworks.algafood.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.dto.input.RestauranteInputDTO;

@Component
public class RestauranteInputDisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Restaurante toDomainObject(RestauranteInputDTO restauranteInputDTO) {

		return modelMapper.map(restauranteInputDTO, Restaurante.class);

	}

	public void copyToDomainObject(RestauranteInputDTO restauranteInputDTO, Restaurante restaurante) {

		// Para evitar execption
		restaurante.setCozinha(new Cozinha());
		
		if (restaurante.getEndereco() != null) {
			restaurante.getEndereco().setCidade(new Cidade());
		}

		modelMapper.map(restauranteInputDTO, restaurante);
	}
}
