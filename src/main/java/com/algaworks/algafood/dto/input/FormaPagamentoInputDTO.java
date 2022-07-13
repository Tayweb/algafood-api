package com.algaworks.algafood.dto.input;

import javax.validation.constraints.NotBlank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FormaPagamentoInputDTO {

	@Schema(example = "Cartão de crédito", required = true)
	@NotBlank
	private String descricao;

}