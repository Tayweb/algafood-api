package com.algaworks.algafood.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FormaPagamentoInputDTO {

    @NotBlank
    private String descricao;
    
}   