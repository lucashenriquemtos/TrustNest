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

class TelefoneTest {

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	@DisplayName("Telefone não deve ser nulo ou em branco")
	public void testTelefoneNotNullOrBlank() {
		Telefone telefone = new Telefone();
		telefone.setNumero(null);

		Set<ConstraintViolation<Telefone>> violations = validator.validate(telefone);

		assertEquals(1, violations.size());
		assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("Telefone é obrigatório.")));
	}

	@Test
	@DisplayName("Telefone deve ter formato válido")
	public void testTelefoneFormat() {
		Telefone telefone = new Telefone();
		telefone.setNumero("1198765432");  // Número inválido (não está no formato correto)

		Set<ConstraintViolation<Telefone>> violations = validator.validate(telefone);

		assertEquals(1, violations.size());
		assertTrue(violations.stream().anyMatch(v -> v.getMessage().equals("Telefone inválido.")));
	}

	@Test
	@DisplayName("Telefone válido não deve gerar violações")
	public void testValidTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(11) 98765-4321");  // Número válido

		Set<ConstraintViolation<Telefone>> violations = validator.validate(telefone);

		assertTrue(violations.isEmpty());
	}

}