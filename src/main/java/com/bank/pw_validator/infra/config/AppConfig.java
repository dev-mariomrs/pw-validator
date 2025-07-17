package com.bank.pw_validator.infra.config;

import com.bank.pw_validator.app.usecase.ValidatePasswordUseCase;
import com.bank.pw_validator.domain.PasswordValidatorPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

/**
 * Método de configuração que define o bean principal para validação de senhas.
 *
 * <p>Seguindo os princípios da <b>Inversão de Controle (IoC)</b> e <b>Injeção de Dependência (DI)</b>,
 * este método fornece a implementação padrão do validador de senhas para todo o contexto da aplicação.</p>
 *
 * <h2>Arquitetura</h2>
 * <ul>
 *   <li><b>Arquitetura Hexagonal</b>: Atua como adaptador entre a infraestrutura Spring e o domínio</li>
 *   <li><b>Clean Architecture</b>: Pertence à camada de Interface Adapters</li>
 *   <li><b>DDD</b>: Mantém a integridade do domínio ao expor apenas a interface</li>
 * </ul>
 *
 * <h2>Responsabilidades</h2>
 * <ul>
 *   <li>Fornecer uma instância única (singleton) do validador de senhas</li>
 *   <li>Garantir que todas as dependências recebam a mesma implementação</li>
 *   <li>Esconder detalhes de implementação atrás da interface</li>
 * </ul>
 * **/
    @Bean
    public PasswordValidatorPort passwordValidator() { // Usa o nome da interface
        return new ValidatePasswordUseCase();
    }
}
