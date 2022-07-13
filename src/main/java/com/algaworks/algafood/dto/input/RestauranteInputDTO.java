package com.algaworks.algafood.dto.input;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.algaworks.algafood.core.validation.TaxaFrete;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestauranteInputDTO {

	@Schema(example = "Comida Caseira", required = true)
	@NotBlank
	private String nome;

	@Schema(example = "10", required = true)
	@NotNull
	@TaxaFrete
	private BigDecimal taxaFrete;

	@Valid
	@NotNull
	private CozinhaIdInputDTO cozinha;

	@Valid
	@NotNull
	private EnderecoInputDTO endereco;
}
