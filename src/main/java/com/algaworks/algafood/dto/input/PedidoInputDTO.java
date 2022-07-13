package com.algaworks.algafood.dto.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoInputDTO {
	
	@Schema(example = "1", required = true)
	@Valid
	@NotNull
	private RestauranteIdInputDTO restaurante;

	@Schema(example = "Endereço", required = true)
	@Valid
	@NotNull
	private EnderecoInputDTO enderecoEntrega;

	@Schema(example = "Cartão de crédito", required = true)
	@Valid
	@NotNull
	private FormaPagamentoIdInputDTO formaPagamento;

	@Valid
	@Size(min = 1)
	@NotNull
	private List<ItemPedidoInputDTO> itens;
}
