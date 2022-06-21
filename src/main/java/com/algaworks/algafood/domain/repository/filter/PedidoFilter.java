package com.algaworks.algafood.domain.repository.filter;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PedidoFilter {

	private Long clienteId;
	private Long restauranteId;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime dataCriacaoInicio;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime dataCriacaoFim;

}
