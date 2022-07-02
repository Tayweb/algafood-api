package com.algaworks.algafood.infrastructure.service.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafood.core.email.EmailProperties;
import com.algaworks.algafood.domain.service.EnvioEmailService;

@Configuration
public class EmailConfig {

	@Autowired
	private EmailProperties emailProperties;

	public EnvioEmailService envioEmailService() {
		switch (emailProperties.getImplEmail()) {
		case FAKE:

			return new FakeEnvioEmailService();

		case SMTP:

			return new SmtpEnvioEmailService();
			
		case SANDBOX:

			return new SandboxEnvioEmailService();

		default:
			return null;
		}
	}
}
