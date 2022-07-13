package com.algaworks.algafood.dto;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class VendaDiaria {

	@Schema(example = "12/07/2022")
	private String data;

	@Schema(example = "20")
	private Long totalVendas;

	@Schema(example = "560.65")
	private BigDecimal totalFaturado;
}
