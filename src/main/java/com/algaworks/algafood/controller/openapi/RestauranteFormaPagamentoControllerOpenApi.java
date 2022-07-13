package com.algaworks.algafood.controller.openapi;

import java.util.List;

import com.algaworks.algafood.dto.FormaPagamentoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

public interface RestauranteFormaPagamentoControllerOpenApi {

	@Operation(summary = "Lista as formas de pagamentos associadas a restaurante")
	List<FormaPagamentoDTO> listar(Long restauranteId);

	@Operation(summary = "Desassociação de restaurante com forma de pagamento")
	void desassociar(
			@Parameter(description = "ID do restaurante e ID da forma de pagamento", example = "1") Long restauranteId,
			Long formaPagamentoId);

	@Operation(summary = "Associação de restaurante com forma de pagamento")
	void associar(
			@Parameter(description = "ID do restaurante e ID da forma de pagamento", example = "1") Long restauranteId,
			Long formaPagamentoId);

}