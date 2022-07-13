package com.algaworks.algafood.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FormaPagamentoDTO {

	@Schema(example = "1")
	private Long id;

	@Schema(example = "Cartão de crédito")
	private String descricao;

}