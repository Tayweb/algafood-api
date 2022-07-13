package com.algaworks.algafood.dto.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoInputDTO {

	@Schema(example = "Lasanha de frango", required = true)
	@NotBlank
	private String nome;

	@Schema(example = "Macarrão, queijo, presuto, frango", required = true)
	@NotBlank
	private String descricao;

	@Schema(example = "30", required = true)
	@NotNull
	@PositiveOrZero
	private BigDecimal preco;

	@Schema(example = "true ou false")
	@NotNull
	private Boolean ativo;
}
