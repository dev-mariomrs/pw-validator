package com.bank.pw_validator;

import com.bank.pw_validator.app.usecase.ValidatePasswordUseCase;
import com.bank.pw_validator.domain.PasswordValidatorPort;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PwValidatorApplicationTests {

	private final PasswordValidatorPort validator = new ValidatePasswordUseCase();

	@Test
	void shouldValidateCorrectPassword() {
		assertTrue(validator.isValid("A1@bcdefgH"));
	}

	@Test
	void shouldRejectShortPassword() {
		assertFalse(validator.isValid("A1@bcde"));
	}

	@Test
	void shouldRejectPasswordWithoutDigit() {
		assertFalse(validator.isValid("Abcdefgh@"));
	}

	@Test
	void shouldRejectPasswordWithoutSpecialChar() {
		assertFalse(validator.isValid("A1bcdefgh"));
	}

	@Test
	void shouldRejectPasswordWithRepeatedChars() {
		assertFalse(validator.isValid("A1@bcdefgA"));
	}

	@Test
	void shouldRejectPasswordWithWhitespace() {
		assertFalse(validator.isValid("A1@bc defg"));
	}

	// Testes adicionais para cobrir mais cenários
	@Test
	void shouldRejectNullPassword() {
		assertFalse(validator.isValid(null));
	}

	@Test
	void shouldRejectPasswordWithoutUppercase() {
		assertFalse(validator.isValid("a1@bcdefgh"));
	}

	@Test
	void shouldRejectPasswordWithoutLowercase() {
		assertFalse(validator.isValid("A1@BCDEFGH"));
	}

	@Test
	void shouldAcceptPasswordWithAllSpecialChars() {
		assertTrue(validator.isValid("A1!@#$%^&*(b"));
	}

	@Test
	void shouldRejectPasswordWithOnlySpecialChars() {
		assertFalse(validator.isValid("!@#$%^&*()"));
	}

}
