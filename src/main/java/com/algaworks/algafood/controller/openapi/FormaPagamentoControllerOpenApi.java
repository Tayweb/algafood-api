package com.algaworks.algafood.controller.openapi;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.dto.FormaPagamentoDTO;
import com.algaworks.algafood.dto.input.FormaPagamentoInputDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Gerencia as formas de pagamento", name = "Forma de Pagamento")
public interface FormaPagamentoControllerOpenApi {

	@Operation(summary = "Lista as forma de pagamento")
	ResponseEntity<List<FormaPagamentoDTO>> listar();

	@Operation(summary = "Busca uma forma de pagamento por ID")
	ResponseEntity<FormaPagamentoDTO> buscar(
			@Parameter(description = "ID da forma de pagamento", example = "1") Long formaPagamentoId);

	@Operation(summary = "Cadastrar uma forma de pagamento")
	FormaPagamentoDTO adicionar(FormaPagamentoInputDTO formaPagamentoInput);

	@Operation(summary = "Atualizar uma forma de pagamento por ID")
	FormaPagamentoDTO atualizar(
			@Parameter(description = "ID da forma de pagamento", example = "1") Long formaPagamentoId,
			FormaPagamentoInputDTO formaPagamentoInput);

	@Operation(summary = "Excluir uma forma de pagamento por ID")
	void remover(@Parameter(description = "ID da forma de pagamento", example = "1") Long formaPagamentoId);

}