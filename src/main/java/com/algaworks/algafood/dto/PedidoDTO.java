package com.algaworks.algafood.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoDTO {
	private String codigo;
	private BigDecimal subtotal;
	private BigDecimal taxaFrete;
	private BigDecimal valorTotal;
	private String status;
	private LocalDateTime dataCriacao;
	private RestauranteResumoDTO restaurante;
	private UsuarioDTO cliente;
}
