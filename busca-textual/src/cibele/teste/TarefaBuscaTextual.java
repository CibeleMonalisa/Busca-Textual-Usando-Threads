package cibele.teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nome;

	public TarefaBuscaTextual(String nomeArquivo, String nome) {
		this.nomeArquivo = nomeArquivo;
		this.nome = nome;
	}

	@Override
	public void run() {
		try {
			Scanner scanner = new Scanner(new File(nomeArquivo));
			int numeroLinha = 1;
			// laço para percorrer todas as linhas do arquivo:
			while(scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				//se a linha CONTER (contains) o nome passado ele é imprimido
				//toLowerCase é para deixar em letras minúsculas
				if(linha.toLowerCase().contains(nome.toLowerCase())) {
					System.out.println(nomeArquivo +  " - " + numeroLinha + " - " + linha);
				}
			
				numeroLinha++;
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
