package br.com.lhmatos.trustnest.common.contato;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Embeddable
@Data
public class Email {

	@NotBlank(message = "E-mail é obrigatório.")
	@jakarta.validation.constraints.Email(message = "E-mail inválido.")
	private String endereco;
}
