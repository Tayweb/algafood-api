package com.algaworks.algafood.controller.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Gerencia o fluxo do pedido", name = "Fluxo do Pedido")
public interface AlteracaoPedidoControllerOpenApi {

	@Operation(summary = "Confirmação de pedido")
	void confirmar(
			@Parameter(description = "Código do pedido", example = "bf0a4efc-ed05-11ec-8ea0-0242ac120002") String codigoPedido);

	@Operation(summary = "Cancelamento de pedido")
	void cancelar(
			@Parameter(description = "Código do pedido", example = "bf0a4efc-ed05-11ec-8ea0-0242ac120002") String codigoPedido);

	@Operation(summary = "Registrar entrega de pedido")
	void entregar(
			@Parameter(description = "Código do pedido", example = "bf0a4efc-ed05-11ec-8ea0-0242ac120002") String codigoPedido);

}