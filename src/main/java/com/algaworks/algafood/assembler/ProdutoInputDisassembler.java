package com.algaworks.algafood.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Produto;
import com.algaworks.algafood.dto.input.ProdutoInputDTO;

@Component
public class ProdutoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public Produto toDomainObject(ProdutoInputDTO produtoInput) {
        return modelMapper.map(produtoInput, Produto.class);
    }
    
    public void copyToDomainObject(ProdutoInputDTO produtoInput, Produto produto) {
        modelMapper.map(produtoInput, produto);
    }   
}