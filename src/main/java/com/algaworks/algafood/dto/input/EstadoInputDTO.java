package com.algaworks.algafood.dto.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstadoInputDTO {

	@NotNull
	private String nome;
}
