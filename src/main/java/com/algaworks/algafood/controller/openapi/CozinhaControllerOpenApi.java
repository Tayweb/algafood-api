package com.algaworks.algafood.controller.openapi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.dto.CozinhaDTO;
import com.algaworks.algafood.dto.input.CozinhaInputDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Gerencia a cozinha", name = "Cozinha")
public interface CozinhaControllerOpenApi {

	@Operation(summary = "Lista as cozinhas")
	Page<CozinhaDTO> listar(Pageable pageable);

	@Operation(summary = "Busca uma cozinha por ID")
	CozinhaDTO buscar(@Parameter(description = "ID da cozinha", example = "1") Long cozinhaId);

	@Operation(summary = "Cadastra uma cozinha")
	CozinhaDTO adicionar(CozinhaInputDTO cozinhaInput);

	@Operation(summary = "Atualiza uma cozinha por ID")
	CozinhaDTO atualizar(@Parameter(description = "ID da cozinha", example = "1") Long cozinhaId,
			CozinhaInputDTO cozinhaInput);

	@Operation(summary = "Exclui uma cozinha")
	ResponseEntity<Cozinha> remover(@Parameter(description = "ID da cozinha", example = "1") Long cozinhaId);

}