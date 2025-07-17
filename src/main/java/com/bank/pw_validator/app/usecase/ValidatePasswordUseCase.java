package com.bank.pw_validator.app.usecase;

import com.bank.pw_validator.domain.rules.PasswordConstraints;
import com.bank.pw_validator.domain.rules.PasswordRules;
import com.bank.pw_validator.domain.PasswordValidatorPort;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementação do caso de uso de validação de senha seguindo os princípios de:
 * - Arquitetura Hexagonal: Atua como um adaptador interno (domínio)
 * - Clean Architecture: Pertence à camada de Enterprise Business Rules
 * - DDD: Implementa regras de negócio do domínio de segurança
 *
 * Responsabilidade: Validar senhas de acordo com políticas de segurança estabelecidas
 */
@Log4j2
public class ValidatePasswordUseCase implements PasswordValidatorPort {

    // Declaração manual do logger (sem Lombok)
    private static final Logger log = LogManager.getLogger(ValidatePasswordUseCase.class);

    /**
     * Valida se uma senha atende a todos os requisitos de segurança
     *
     * @param password A senha a ser validada
     * @return true se a senha for válida, false caso contrário
     *
     */
    @Override
    public boolean isValid(String password) {
        log.debug("Validando senha...");
        return PasswordRules.hasMinimumLength(password, PasswordConstraints.MIN_PASSWORD_LENGTH) &&
                PasswordRules.hasAtLeastOneDigit(password) &&
                PasswordRules.hasAtLeastOneLowercase(password) &&
                PasswordRules.hasAtLeastOneUppercase(password) &&
                PasswordRules.hasAtLeastOneSpecialChar(password) &&
                PasswordRules.hasNoRepeatedChars(password)  &&
                PasswordRules.hasNoWhitespaces(password);

    }
}
