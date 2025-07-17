package com.bank.pw_validator.domain.rules;

import java.util.Set;

/**
 * Classe utilitária que implementa as regras de validação de senha para sistemas bancários.
 *
 * <p>Seguindo os princípios de <b>Domain-Driven Design</b>, esta classe encapsula
 * as regras de negócio específicas para validação de senhas no domínio bancário.</p>
 *
 * <p>Na <b>Arquitetura Hexagonal</b>, estas regras pertencem ao núcleo do domínio
 * e são utilizadas pelos adaptadores primários (casos de uso).</p>
 *
 * <p>Na <b>Clean Architecture</b>, esta classe está na camada de Enterprise Business Rules,
 * contendo regras essenciais e estáveis do negócio.</p>
 */
public class PasswordRules {

    /**
     * Conjunto de caracteres especiais permitidos em senhas bancárias.
     *
     * <p>Caracteres definidos conforme política de segurança PCI-DSS e regulamentação bancária:
     * ! @ # $ % ˆ & * ( ) - +</p>
     *
     * <p><b>Importante:</b> O caractere 'ˆ' (circunflexo) foi incluído para compatibilidade
     * com sistemas legados, porém seu uso é desencorajado em novas implementações.</p>
     */
    private  static final Set<Character> SPECIAL_CHARS =
            Set.of('!','@','#','$','%','ˆ','&','*','(',')','-','+');

    /**
     * Verifica se a senha atende ao comprimento mínimo requerido.
     *
     * @param password A senha a ser validada
     * @param minLength Comprimento mínimo exigido
     * @return true se a senha for não-nula e com comprimento >= minLength
     */
    public static boolean hasMinimumLength(String password, int minLength) {
        return password != null && password.length() >= minLength;
    }

    /**
     * Verifica se a senha contém pelo menos um dígito numérico.
     *
     * @param password A senha a ser validada
     * @return true se a senha for não-nula e contiver pelo menos um dígito (0-9)
     */
    public static boolean hasAtLeastOneDigit(String password) {
        return password != null && password.chars().anyMatch(Character::isDigit);
    }

    /**
     * Verifica se a senha contém pelo menos uma letra minúscula.
     *
     * @param password A senha a ser validada
     * @return true se a senha for não-nula e contiver pelo menos um caractere a-z
     */
    public static boolean hasAtLeastOneLowercase(String password) {
        return password != null && password.chars().anyMatch(Character::isLowerCase);
    }

    /**
     * Verifica se a senha contém pelo menos uma letra maiúscula.
     *
     * @param password A senha a ser validada
     * @return true se a senha for não-nula e contiver pelo menos um caractere A-Z
     */
    public static boolean hasAtLeastOneUppercase(String password) {
        return password != null && password.chars().anyMatch(Character::isUpperCase);
    }

    /**
     * Verifica se a senha contém pelo menos um caractere especial.
     *
     * @param password A senha a ser validada
     * @return true se a senha for não-nula e contiver pelo menos um caractere especial
     *         conforme definido em SPECIAL_CHARS
     */
    public static boolean hasAtLeastOneSpecialChar(String password) {
        return password != null &&
                password.chars()
                        .mapToObj(c -> (char) c)
                        .anyMatch(SPECIAL_CHARS::contains);
    }

    /**
     * Verifica se a senha não contém caracteres repetidos (ignorando espaços).
     *
     * @param password A senha a ser validada
     * @return false se a senha for nula ou contiver caracteres repetidos (case-sensitive)
     */
    public static boolean hasNoRepeatedChars(String password) {
        if (password == null) return false;

        String cleanPassword = password.replaceAll("\\s+", "");
        return cleanPassword.chars().distinct().count() == cleanPassword.length();

    }

    /**
     * Verifica se a senha não contém espaços em branco.
     *
     * @param password A senha a ser validada
     * @return false se a senha for nula ou contiver espaços, tabs ou outros whitespaces
     */
    public static boolean hasNoWhitespaces(String password) {
        return (password != null) && !password.chars().anyMatch(Character::isWhitespace);
    }


}
