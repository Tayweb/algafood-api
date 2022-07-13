package com.algaworks.algafood.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnderecoInputDTO {

	@Schema(example = "49160000", required = true)
	@NotBlank
	private String cep;
	
	@Schema(example = "Rua 12", required = true)
	@NotBlank
	private String logradouro;
	
	@Schema(example = "42", required = true)
	@NotBlank
	private String numero;

	@Schema(example = "Ao lado da escola dali", required = true)
	private String complemento;
	
	@Schema(example = "Zona Oeste", required = true)
	@NotBlank
	private String bairro;
	
	@Schema(example = "Aracaju", required = true)
	@Valid
	@NotNull
	private CidadeInputDTO cidade;
}
