package br.com.lhmatos.trustnest.titular;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Getter
@Table(name = "titular")
abstract class Titular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String documentoIdentificacao;

	@Column(nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status = Status.ATIVO;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao = new Date();

	public enum Status {
		ATIVO, INATIVO, BLOQUEADO
	}
}
