package br.com.lhmatos.trustnest.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoLogradouro {

	AVENIDA("Avenida", "Av."),
	RUA("Rua", "R."),
	ALAMEDA("Alameda", "Al."),
	PRACA("Praça", "Pç."),
	TRAVESSA("Travessa", "Tv."),
	RODOVIA("Rodovia", "Rod."),
	ESTRADA("Estrada", "Est."),
	VIELA("Viela", "Vl."),
	BECO("Beco", "Bc."),
	LARGO("Largo", "Lg."),
	VILA("Vila", "Vl."),
	PASSAGEM("Passagem", "Pass."),
	CAMINHO("Caminho", "Cam."),
	QUADRA("Quadra", "Qd."),
	LOTEAMENTO("Loteamento", "Lt."),
	PARQUE("Parque", "Pq."),
	VIADUTO("Viaduto", "Vd."),
	CONDOMINIO("Condomínio", "Cond."),
	SETOR("Setor", "Set."),
	SITIO("Sítio", "Sit."),
	CHACARA("Chácara", "Ch."),
	FAVELA("Favela", "Fv.");

	private final String descricao;
	private final String abreviacao;

}
