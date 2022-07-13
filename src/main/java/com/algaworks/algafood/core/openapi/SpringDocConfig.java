package com.algaworks.algafood.core.openapi;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;

@Configuration

public class SpringDocConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("springshop-public").pathsToMatch("/**/public/**").build();
	}

	@Bean
	GroupedOpenApi usuarioApis() { // agrupar todas as APIs com `usuario` no caminho
		return GroupedOpenApi.builder().group("usuarios").pathsToMatch("/**/usuarios/**").build();
	}

	@Bean
	GroupedOpenApi grupoApis() { // agrupar todas as APIs com `grupo` no caminho
		return GroupedOpenApi.builder().group("grupo").pathsToMatch("/**/grupo/**").build();
	}

	@Bean
	GroupedOpenApi cozinhasApis() { // agrupar todas as APIs com `cozinhas` no caminho
		return GroupedOpenApi.builder().group("cozinhas").pathsToMatch("/**/cozinhas/**").build();
	}

	@Bean
	GroupedOpenApi restaurantesApis() { // agrupar todas as APIs com `cozinhas` no caminho
		return GroupedOpenApi.builder().group("restaurantes").pathsToMatch("/**/restaurantes/**").build();
	}

	@Bean
	GroupedOpenApi produtosApis() { // agrupar todas as APIs com `cozinhas` no caminho
		return GroupedOpenApi.builder().group("produtos").pathsToMatch("/**/produtos/**").build();
	}

	@Bean
	GroupedOpenApi pedidosApis() { // agrupar todas as APIs com `pedidos` no caminho
		return GroupedOpenApi.builder().group("pedidos").pathsToMatch("/**/pedidos/**").build();
	}

	@Bean
	GroupedOpenApi formaPagamentoApis() { // agrupar todas as APIs com `cozinhas` no caminho
		return GroupedOpenApi.builder().group("formas-pagamento").pathsToMatch("/**/formas-pagamento/**").build();
	}

	@Bean
	GroupedOpenApi estadoApis() { // agrupar todas as APIs com `cozinhas` no caminho
		return GroupedOpenApi.builder().group("estado").pathsToMatch("/**/estado/**").build();
	}

	@Bean
	GroupedOpenApi estatisticaApis() { // agrupar todas as APIs com `cozinhas` no caminho
		return GroupedOpenApi.builder().group("estatisticas").pathsToMatch("/**/estatisticas/**").build();
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components())
				.info(new Info().title("AlgaFood API").description("API aberta para clientes e restaurantes")
						.version("1").contact(new Contact().name("Tayweb").email("tayweb70@gmail.com")));
	}

	@Bean
	public OperationCustomizer customizeOperation() {
		return (operation, handlerMethod) -> operation
				.responses(operation.getResponses().addApiResponse("401", new ApiResponse().$ref("Unauthenticated"))
						.addApiResponse("403", new ApiResponse().$ref("Unauthorized"))
						.addApiResponse("500", new ApiResponse().$ref("Erro Interno do Servidor")));
	}

}
