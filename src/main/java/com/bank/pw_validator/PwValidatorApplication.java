package com.bank.pw_validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal de inicialização da aplicação de validação de senhas bancárias.
 *
 * <p>Esta classe é o ponto de entrada do Spring Boot para o serviço de validação de senhas,
 * responsável por iniciar todo o contexto da aplicação e configurar o container Spring.</p>
 *
 * <h2>Funcionalidades Principais</h2>
 * <ul>
 *   <li>Inicialização automática do contexto Spring</li>
 *   <li>Disponibilização do serviço via embedded Tomcat/Jetty</li>
 * </ul>
 *
 * <h2>Arquitetura</h2>
 * <ul>
 *   <li><b>Spring Boot</b>: Utiliza o starter padrão para aplicações web</li>
 *   <li><b>Arquitetura Hexagonal</b>: Configura os adaptadores e portas</li>
 *   <li><b>Clean Architecture</b>: Organiza os pacotes por camadas</li>
 * </ul>
 *
 * <h2>Como Executar</h2>
 * <pre>
 * # Via linha de comando
 * mvn spring-boot:run
 *
 * # Ou executando diretamente
 * java -jar target/pw-validator-1.0.0.jar
 * </pre>
 * **/
@SpringBootApplication
public class PwValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PwValidatorApplication.class, args);
	}

}
