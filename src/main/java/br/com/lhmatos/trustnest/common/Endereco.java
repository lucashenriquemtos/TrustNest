package br.com.lhmatos.trustnest.common;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Endereco {

	@Enumerated(EnumType.STRING)
	@NotNull(message = "O Tipo de logradouro não pode ser nulo")
	private TipoLogradouro tipoLogradouro;

	@NotBlank(message = "O Logradouro é obrigatório.")
	@Size(max = 255, message = "Logradouro deve ter no máximo 255 caracteres.")
	private String logradouro;

	@NotBlank(message = "Número é obrigatório.")
	@Size(max = 20, message = "Número deve ter no máximo 20 caracteres.")
	private String numero;

	@Size(max = 255, message = "Complemento deve ter no máximo 255 caracteres.")
	private String complemento;

	@NotBlank(message = "Bairro é obrigatório.")
	@Size(max = 100, message = "Bairro deve ter no máximo 100 caracteres.")
	private String bairro;

	@NotBlank(message = "Cidade é obrigatório.")
	@Size(max = 100, message = "Cidade deve ter no máximo 100 caracteres.")
	private String cidade;

	@NotBlank(message = "Estado é obrigatório.")
	@Size(min = 5, max = 100, message = "Estado deve ter no máximo 100 caracteres.")
	private String estado;

	@NotBlank(message = "CEP é obrigatório.")
	@Pattern(regexp = "^[0-9]{5}-[0-9]{3}$", message = "CEP inválido.")
	private String cep;

}
