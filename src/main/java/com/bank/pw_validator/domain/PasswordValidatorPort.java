package com.bank.pw_validator.domain;

/**
 * Interface que define o contrato para validação de senhas no domínio bancário.
 *
 * <p>Seguindo os princípios da <b>Arquitetura Hexagonal</b>, esta interface representa
 * uma <i>Porta</i> do domínio, permitindo a comunicação entre o núcleo da aplicação
 * e os adaptadores externos.</p>
 *
 * <p>Na <b>Clean Architecture</b>, esta interface pertence à camada de <i>Enterprise Business Rules</i>,
 * definindo uma regra fundamental do domínio sem dependências externas.</p>
 *
 * <p>No <b>Domain-Driven Design</b>, faz parte do <i>Ubiquitous Language</i> do domínio de segurança,
 * representando explicitamente o conceito de validação de senhas.</p>
 *
 * <h2>Responsabilidade</h2>
 * Definir o contrato único para validação de senhas conforme políticas de segurança do banco,
 * incluindo complexidade mínima, caracteres obrigatórios e restrições de composição.
 **/
 public interface PasswordValidatorPort {
    /**
     * Valida se uma senha atende a todos os requisitos de segurança.
     *
     * @param password A senha a ser validada (não criptografada)
     * @return {@code true} se a senha atender a todos os critérios:
     *         <ul>
     *           <li>Comprimento mínimo</li>
     *           <li>Presença de caracteres especiais</li>
     *           <li>Combinação de maiúsculas/minúsculas</li>
     *           <li>Não repetição de caracteres</li>
     *           <li>Demais regras específicas do banco</li>
     *         </ul>
     * @return  {@code false} Caso contrário
     */
    boolean isValid(String password);
}
