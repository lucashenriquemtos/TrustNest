package br.com.lhmatos.trustnest.common;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

	private Endereco endereco;
	private static ValidatorFactory validatorFactory;
	private static Validator validator;

	@BeforeAll
	static void createValidator() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@AfterAll
	static void close() {
		validatorFactory.close();
	}

	@BeforeEach
	void setUp(){
		endereco = new Endereco(TipoLogradouro.RUA,
				"Paulista",
				"100",
				"Apto 10",
				"Bela Vista",
				"São Paulo",
				"SP",
				"01010-000");
	}

	@Test
	@DisplayName("Quando Endereço é construído com todos os campos, ele deve ser criado com sucesso")
	void testEnderecoConstruidoComTodosCampos() {
		assertNotNull(endereco);
		assertEquals(TipoLogradouro.RUA, endereco.getTipoLogradouro());
		assertEquals("Paulista", endereco.getLogradouro());
		assertEquals("100", endereco.getNumero());
		assertEquals("Apto 10", endereco.getComplemento());
		assertEquals("Bela Vista", endereco.getBairro());
		assertEquals("São Paulo", endereco.getCidade());
		assertEquals("SP", endereco.getEstado());
		assertEquals("01010-000", endereco.getCep());
	}

	@Test
	@DisplayName("Quando Endereço é construído com TipoLogradouro nulo, uma violação deve ser detectada")
	void testEnderecoComTipoLogradouroNulo() {

		Endereco endereco = new Endereco(null, "Paulista", "100", "Apto 10",
				"Bela Vista", "São Paulo", "SP", "01010-000");


		Set<ConstraintViolation<Endereco>> violations = validator.validate(endereco);


		assertFalse(violations.isEmpty(), "Deveria haver violações de validação");


		assertTrue(violations.stream().anyMatch(v -> "O Tipo de logradouro não pode ser nulo".equals(v.getMessage())),
				"Deveria haver uma violação relacionada ao tipo de logradouro nulo");
	}




}