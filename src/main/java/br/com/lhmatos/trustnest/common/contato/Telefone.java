package br.com.lhmatos.trustnest.common.contato;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Embeddable
@Data
public class Telefone {

	@NotBlank(message = "Telefone é obrigatório.")
	@Pattern(regexp = "^[1-9]{2}[9]?[0-9]{8}$", message = "Telefone inválido.")
	private String numero;
}
