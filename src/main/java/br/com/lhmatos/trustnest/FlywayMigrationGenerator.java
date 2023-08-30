package br.com.lhmatos.trustnest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FlywayMigrationGenerator {
	private static final String MIGRATIONS_DIR = "src/main/resources/db/migration/";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Insira a descrição da migração: ");
		String descricao = scanner.nextLine().trim().replace(' ', '_');

		String dataHora = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String nomeArquivoMigracao = MIGRATIONS_DIR + "V" + dataHora + "__" + descricao + ".sql";

		try {
			Files.createFile(Paths.get(nomeArquivoMigracao));
			System.out.println("Arquivo de migração criado: " + nomeArquivoMigracao);
		} catch (IOException e) {
			System.out.println("Erro ao criar o arquivo de migração: " + e.getMessage());
		}
	}
}
