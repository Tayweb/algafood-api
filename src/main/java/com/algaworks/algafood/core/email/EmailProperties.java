package com.algaworks.algafood.core.email;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("algafood.email")
public class EmailProperties {

	@NotNull
	private String remetente;
	private ImplementacaoEmail implEmail;
	private Sandbox sandbox = new Sandbox();

	public enum ImplementacaoEmail {
		SMTP, FAKE, SANDBOX
	}

	@Getter
	@Setter
	public class Sandbox {
		private String destinatario;
	}
}
