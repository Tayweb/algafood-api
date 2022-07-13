package com.algaworks.algafood.controller.openapi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algafood.domain.filter.PedidoFilter;
import com.algaworks.algafood.dto.PedidoDTO;
import com.algaworks.algafood.dto.input.PedidoInputDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(description = "Gerencia os pedidos", name = "Pedido")
public interface PedidoControllerOpenApi {

	@Operation(summary = "Pesquisa os pedidos", parameters = @Parameter(in = ParameterIn.QUERY,
			description = "Nomes das propriedades para filtrar na resposta, separados por vígula", 
			name = "campos", 
			content = @Content(schema = @Schema(type = "string")))) /*Para paramtro implicito*/			
	Page<PedidoDTO> pesquisar(PedidoFilter filtro, Pageable pageable);
	
	@Operation(summary = "Busca um pedido por código" , parameters = @Parameter(in = ParameterIn.QUERY, 
			description = "Nomes das propriedades para filtrar na resposta, separados por vígula", 
			name = "campos", 
			content = @Content(schema = @Schema(type = "string")))) /*Para paramtro implicito*/	
	PedidoDTO buscar(
			@Parameter(description = "Código do pedido", example = "bf0a4efc-ed05-11ec-8ea0-0242ac120002") String codigoPedido);

	@Operation(summary = "Registra um pedido")
	PedidoDTO adicionar(PedidoInputDTO pedidoInput);

}