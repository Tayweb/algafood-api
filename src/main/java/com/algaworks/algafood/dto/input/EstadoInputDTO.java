package com.algaworks.algafood.dto.input;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstadoInputDTO {

	@Schema(example = "Sergipe", required = true)
	@NotNull
	private String nome;
}
