package com.bank.pw_validator.infra.web;

import com.bank.pw_validator.domain.PasswordValidatorPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para validação de senhas bancárias.
 *
 * <p>Este controller implementa o endpoint público para validação de senhas
 * conforme as políticas de segurança do banco.</p>
 *
 * <h2>Arquitetura</h2>
 * <ul>
 *   <li><b>Hexagonal</b>: Atua como adaptador primário (entrada HTTP → domínio)</li>
 *   <li><b>Clean Architecture</b>: Pertence à camada de Interface Adapters</li>
 *   <li><b>DDD</b>: Traduz DTOs em chamadas ao domínio</li>
 * </ul>
 *
 * <h2>Endpoint</h2>
 * <table>
 *   <tr><td><b>Método</b></td><td>POST</td></tr>
 *   <tr><td><b>URI</b></td><td>/api/v1/password/validate</td></tr>
 *   <tr><td><b>Consumes</b></td><td>application/json</td></tr>
 *   <tr><td><b>Produces</b></td><td>application/json</td></tr>
 * </table>
 *
 * <h2>Exemplo de Requisição</h2>
 * <pre>
 * POST /api/v1/password/validate
 * {
 *   "password": "Senha@123"
 * }</pre>
 *
 * <h2>Exemplo de Resposta</h2>
 * <pre>
 * HTTP/1.1 200 OK
 * {
 *   "isValid": true
 * }</pre>
 */
@RestController
@RequestMapping("/api/v1/password")
public class ValidatePasswordController {

    private final PasswordValidatorPort passwordValidator;

    // Injeção de dependência via construtor
    public ValidatePasswordController(PasswordValidatorPort passwordValidator) {
        this.passwordValidator = passwordValidator;
    }

    @PostMapping("/validate")
    public ResponseEntity<PasswordValidationResponse> validatePassword(
            @RequestBody PasswordValidationRequest request ) {

        boolean isValid = passwordValidator.isValid(request.password);

        return ResponseEntity.ok(new PasswordValidationResponse(isValid));

    }

    // DTOs para request/response
    record PasswordValidationRequest(String password) {}
    record PasswordValidationResponse(boolean isValid) {}
}
