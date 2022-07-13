package com.algaworks.algafood.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioInputDTO {

	@Schema(example = "Maria", required = true)
	@NotBlank
	private String nome;

	@Schema(example = "maria@gmail.com", required = true)
	@NotBlank
	@Email
	private String email;
}
