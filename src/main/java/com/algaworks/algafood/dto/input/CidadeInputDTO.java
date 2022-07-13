package com.algaworks.algafood.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CidadeInputDTO {

	@Schema(example = "Aracaju", required = true)
	@NotBlank
	private String nome;

	@Schema(example = "Sergipe", required = true)
	@Valid
	@NotNull
	private EstadoIdInputDTO estado;

}
