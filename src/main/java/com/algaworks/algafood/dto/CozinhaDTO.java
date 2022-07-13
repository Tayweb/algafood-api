package com.algaworks.algafood.dto;

import com.algaworks.algafood.domain.view.RestauranteView;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaDTO {

	@Schema(example = "1")
	@JsonView(RestauranteView.Resumo.class)
	private Long id;

	@Schema(example = "Tailandesa")
	@JsonView(RestauranteView.Resumo.class)
	private String nome;

}
