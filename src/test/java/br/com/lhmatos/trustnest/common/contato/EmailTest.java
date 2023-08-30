package br.com.lhmatos.trustnest.common.contato;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

	private Validator validator;

	@BeforeEach
	public void setUp() {
		try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
			validator = factory.getValidator();
		}
	}

	@Test
	@DisplayName("E-mail não deve ser nulo ou em branco")
	public void testEmailNotNullOrBlank() {
		Email email = new Email();
		email.setEndereco(null);

		Set<ConstraintViolation<Email>> violations = validator.validate(email);

		assertEquals(1, violations.size());
		assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("E-mail é obrigatório.")));
	}

	@Test
	@DisplayName("E-mail deve ter formato válido")
	public void testEmailFormat() {
		Email email = new Email();
		email.setEndereco("invalidEmailFormat");

		Set<ConstraintViolation<Email>> violations = validator.validate(email);

		assertEquals(1, violations.size());
		assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("E-mail inválido.")));
	}

	@Test
	@DisplayName("E-mail válido não deve gerar violações se estiver preenchido e for válido")
	public void testValidEmail() {
		Email email = new Email();
		email.setEndereco("example@example.com");

		Set<ConstraintViolation<Email>> violations = validator.validate(email);

		assertTrue(violations.isEmpty());
	}

}