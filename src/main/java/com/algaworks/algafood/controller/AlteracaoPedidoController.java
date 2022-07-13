package com.algaworks.algafood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.controller.openapi.AlteracaoPedidoControllerOpenApi;
import com.algaworks.algafood.domain.service.AlteracaoPedidoService;

@RestController
@RequestMapping(value = "/pedidos/{codigoPedido}")
public class AlteracaoPedidoController implements AlteracaoPedidoControllerOpenApi {

	@Autowired
	private AlteracaoPedidoService alteracaoPedidoService;

	@Override
	@PutMapping("/confirmacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void confirmar(@PathVariable String codigoPedido) {

		alteracaoPedidoService.confirmar(codigoPedido);
	}

	@Override
	@PutMapping("/cancelamento")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cancelar(@PathVariable String codigoPedido) {
		alteracaoPedidoService.cancelar(codigoPedido);
	}

	@Override
	@PutMapping("/entrega")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void entregar(@PathVariable String codigoPedido) {
		alteracaoPedidoService.entregar(codigoPedido);
	}
}
