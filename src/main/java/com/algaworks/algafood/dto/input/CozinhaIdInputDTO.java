package com.algaworks.algafood.dto.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CozinhaIdInputDTO {
	@Schema(example = "1", required = true)
	private Long id;
}
