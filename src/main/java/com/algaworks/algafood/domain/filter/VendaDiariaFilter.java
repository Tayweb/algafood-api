package com.algaworks.algafood.domain.filter;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VendaDiariaFilter {

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime dataCriacaoInicio;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime dataCriacaoFim;
}
