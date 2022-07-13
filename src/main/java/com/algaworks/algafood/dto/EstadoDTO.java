package com.algaworks.algafood.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstadoDTO {

	@Schema(example = "1")
	private Long id;

	@Schema(example = "Paraná")
	private String nome;
}
