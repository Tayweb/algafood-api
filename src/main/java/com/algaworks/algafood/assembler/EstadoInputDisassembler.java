package com.algaworks.algafood.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.dto.input.EstadoInputDTO;

@Component
public class EstadoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public Estado toDomainObject(EstadoInputDTO estadoInput) {
        return modelMapper.map(estadoInput, Estado.class);
    }
    
    public void copyToDomainObject(EstadoInputDTO estadoInput, Estado estado) {
        modelMapper.map(estadoInput, estado);
    }   
}   