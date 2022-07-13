package com.algaworks.algafood.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoDTO {
	@Schema(example = "bf0a4efc-ed05-11ec-8ea0-0242ac120002")
	private String codigo;

	@Schema(example = "23.60")
	private BigDecimal subtotal;

	@Schema(example = "10")
	private BigDecimal taxaFrete;

	@Schema(example = "33.60")
	private BigDecimal valorTotal;

	@Schema(example = "CRIADO")
	private String status;

	@Schema(example = "2022-06-22T00:00:00")
	private LocalDateTime dataCriacao;

	@Schema(example = "Restaurante")
	private RestauranteResumoDTO restaurante;

	@Schema(example = "Cliente")
	private UsuarioDTO cliente;
}
