package com.algaworks.algafood.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioDTO {

	@Schema(example = "1")
	private Long id;

	@Schema(example = "Maria")
	private String nome;
	
	@Schema(example = "maria@gmail.com")
	private String email;
}
