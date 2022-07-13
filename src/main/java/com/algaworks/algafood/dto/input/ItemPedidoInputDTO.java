package com.algaworks.algafood.dto.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemPedidoInputDTO {

	@Schema(example = "1", required = true)
	@NotNull
	private Long produtoId;

	@Schema(example = "3", required = true)
	@NotNull
	@PositiveOrZero
	private Integer quantidade;

	@Schema(example = "Sem salada", required = true)
	private String observacao;
}
