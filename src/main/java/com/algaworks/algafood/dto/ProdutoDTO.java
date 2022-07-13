package com.algaworks.algafood.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoDTO {

	@Schema(example = "1")
	private Long id;

	@Schema(example = "Lasanha de frango")
	private String nome;

	@Schema(example = "Macarrão, queijo, presuto, frango")
	private String descricao;

	@Schema(example = "30")
	private BigDecimal preco;

	@Schema(example = "true ou false")
	private Boolean ativo;
}
