package com.algaworks.algafood.dto;

import java.math.BigDecimal;

import com.algaworks.algafood.domain.view.RestauranteView;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteDTO {

	@Schema(example = "1")
	@JsonView(RestauranteView.Resumo.class)
	private Long id;

	@Schema(example = "Comida boa")
	@JsonView(RestauranteView.Resumo.class)
	private String nome;

	@Schema(example = "10")
	@JsonView(RestauranteView.Resumo.class)
	private BigDecimal taxaFrete;

	@JsonView(RestauranteView.Resumo.class)
	private CozinhaDTO cozinha;

	@Schema(example = "true ou false")
	private Boolean ativo;
	private EnderecoDTO endereco;
	private Boolean aberto;
}
