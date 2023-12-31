package br.com.lhmatos.trustnest.common.contato;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Embeddable
@Data
public class Telefone {

	@NotBlank(message = "Telefone é obrigatório.")
	@Pattern(regexp = "^\\(\\d{2}\\) \\d{5}-\\d{4}$", message = "Telefone inválido.")
	private String numero;
}

