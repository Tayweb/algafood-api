package com.algaworks.algafood.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioInputDTO {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;
}
