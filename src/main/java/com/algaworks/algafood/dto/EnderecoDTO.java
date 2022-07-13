package com.algaworks.algafood.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO {

	@Schema(example = "49160000")
	private String cep;

	@Schema(example = "Rua 12")
	private String logradouro;

	@Schema(example = "12")
	private String numero;

	@Schema(example = "Próximo a famácia cura tudo")
	private String complemento;

	@Schema(example = "Zona Oeste")
	private String bairro;

	private CidadeResumoDTO cidade;
}
