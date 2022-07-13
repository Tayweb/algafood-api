package com.algaworks.algafood.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.assembler.FormaPagamentoInputDisassembler;
import com.algaworks.algafood.assembler.FormaPagamentoModelAssembler;
import com.algaworks.algafood.controller.openapi.FormaPagamentoControllerOpenApi;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import com.algaworks.algafood.domain.service.CadastroFormaPagamentoService;
import com.algaworks.algafood.dto.FormaPagamentoDTO;
import com.algaworks.algafood.dto.input.FormaPagamentoInputDTO;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController implements FormaPagamentoControllerOpenApi {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamento;

	@Autowired
	private FormaPagamentoModelAssembler formaPagamentoModelAssembler;

	@Autowired
	private FormaPagamentoInputDisassembler formaPagamentoInputDisassembler;

	@Override
	@GetMapping
	public ResponseEntity<List<FormaPagamentoDTO>> listar() {
		List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.findAll();

		List<FormaPagamentoDTO> formaPagamentos = formaPagamentoModelAssembler.toCollectionModel(todasFormasPagamentos);

		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS)).body(formaPagamentos);

	}

	@Override
	@GetMapping("/{formaPagamentoId}") 
	public ResponseEntity<FormaPagamentoDTO> buscar(@PathVariable Long formaPagamentoId) {
		FormaPagamento formaPagamento = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);

		FormaPagamentoDTO formaPagamentoDTO = formaPagamentoModelAssembler.toModel(formaPagamento);

		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(10, TimeUnit.SECONDS)).body(formaPagamentoDTO);
	}

	@Override
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamentoDTO adicionar(@RequestBody @Valid FormaPagamentoInputDTO formaPagamentoInput) {
		FormaPagamento formaPagamento = formaPagamentoInputDisassembler.toDomainObject(formaPagamentoInput);

		formaPagamento = cadastroFormaPagamento.salvar(formaPagamento);

		return formaPagamentoModelAssembler.toModel(formaPagamento);
	}

	@Override
	@PutMapping("/{formaPagamentoId}")
	public FormaPagamentoDTO atualizar(@PathVariable Long formaPagamentoId,
			@RequestBody @Valid FormaPagamentoInputDTO formaPagamentoInput) {
		FormaPagamento formaPagamentoAtual = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);

		formaPagamentoInputDisassembler.copyToDomainObject(formaPagamentoInput, formaPagamentoAtual);

		formaPagamentoAtual = cadastroFormaPagamento.salvar(formaPagamentoAtual);

		return formaPagamentoModelAssembler.toModel(formaPagamentoAtual);
	}

	@Override
	@DeleteMapping("/{formaPagamentoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long formaPagamentoId) {
		cadastroFormaPagamento.excluir(formaPagamentoId);
	}
}
