package com.algaworks.algafood.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.assembler.RestauranteInputDisassembler;
import com.algaworks.algafood.assembler.RestauranteModelAssembler;
import com.algaworks.algafood.controller.openapi.RestauranteControllerOpenApi;
import com.algaworks.algafood.domain.exception.CidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.CozinhaNaoEncontradoException;
import com.algaworks.algafood.domain.exception.NegocioException;
import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import com.algaworks.algafood.domain.view.RestauranteView;
import com.algaworks.algafood.dto.RestauranteDTO;
import com.algaworks.algafood.dto.input.RestauranteInputDTO;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController implements RestauranteControllerOpenApi {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CadastroRestauranteService cadastroRestauranteService;

	@Autowired
	private RestauranteModelAssembler restauranteModelAssembler;

	@Autowired
	private RestauranteInputDisassembler restauranteInputDisassembler;

	@Override
	@JsonView(RestauranteView.Resumo.class)
	@GetMapping
	public List<RestauranteDTO> listar() {

		List<Restaurante> restauranteDTOs = restauranteRepository.findAll();

		return restauranteModelAssembler.toCollectionDTO(restauranteDTOs);
	}

	@Override
	@GetMapping("/{restauranteId}")
	public RestauranteDTO buscarPorId(@PathVariable Long restauranteId) {

		Restaurante restaurante = cadastroRestauranteService.buscarRestaurante(restauranteId);
		return restauranteModelAssembler.toModel(restaurante);

	}

	@Override
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public RestauranteDTO salvar(@RequestBody @Valid RestauranteInputDTO restauranteInputDTO) {

		try {
			Restaurante restaurante = restauranteInputDisassembler.toDomainObject(restauranteInputDTO);
			return restauranteModelAssembler.toModel(cadastroRestauranteService.salvar(restaurante));
		} catch (CozinhaNaoEncontradoException | CidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage());
		}
	}

	@Override
	@PutMapping("/{restauranteId}")
	public RestauranteDTO atualizar(@PathVariable Long restauranteId,
			@RequestBody @Valid RestauranteInputDTO restauranteInputDTO) {

		try {

			Restaurante restauranteAtual = cadastroRestauranteService.buscarRestaurante(restauranteId);

			restauranteInputDisassembler.copyToDomainObject(restauranteInputDTO, restauranteAtual);

			return restauranteModelAssembler.toModel(cadastroRestauranteService.salvar(restauranteAtual));

		} catch (CozinhaNaoEncontradoException | CidadeNaoEncontradaException e) {
			throw new NegocioException(e.getMessage(), e);
		}

	}

	@Override
	@PutMapping("/{restauranteId}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void ativar(@PathVariable Long restauranteId) {
		cadastroRestauranteService.ativarRestaurante(restauranteId);
	}

	@Override
	@DeleteMapping("/{restauranteId}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void inativar(@PathVariable Long restauranteId) {
		cadastroRestauranteService.desativarRestaurante(restauranteId);
	}

	@Override
	@PutMapping("/{restauranteId}/abertura")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void abrir(@PathVariable Long restauranteId) {
		cadastroRestauranteService.abrir(restauranteId);
	}

	@Override
	@PutMapping("/{restauranteId}/fechamento")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void fechar(@PathVariable Long restauranteId) {
		cadastroRestauranteService.fechar(restauranteId);
	}

	@Override
	@PutMapping("/ativacoes")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void ativarMultiplos(@RequestBody List<Long> restaurantesIds) {
		try {
			cadastroRestauranteService.ativar(restaurantesIds);
		} catch (RestauranteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@Override
	@DeleteMapping("/ativacoes")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void inativarMultiplos(@RequestBody List<Long> restaurantesIds) {
		try {
			cadastroRestauranteService.inativar(restaurantesIds);
		} catch (RestauranteNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}

	}

}
