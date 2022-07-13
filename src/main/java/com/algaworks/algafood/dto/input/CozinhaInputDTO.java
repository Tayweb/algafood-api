package com.algaworks.algafood.dto.input;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CozinhaInputDTO {

	@Schema(example = "Tailandesa", required = true)
	@NotBlank
	private String nome;

}
