package com.algaworks.algafood.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Pedido;
import com.algaworks.algafood.dto.input.PedidoInputDTO;

@Component
public class PedidoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public Pedido toDomainObject(PedidoInputDTO pedidoInput) {
        return modelMapper.map(pedidoInput, Pedido.class);
    }
    
    public void copyToDomainObject(PedidoInputDTO pedidoInput, Pedido pedido) {
        modelMapper.map(pedidoInput, pedido);
    }            
}