package br.com.udemy.java.secao17;

import java.io.File;

public class Aula218ManipulandoPastasComFile {

	public static void main(String[] args) {
		
		System.out.println("LISTANDO PASTAS");
		System.out.println();
		
		File pasta = new File("c:\\temp\\");
		
		File[] paths = pasta.listFiles(File::isDirectory);
		
		for ( File arquivo : paths  ) {
			
			System.out.println(arquivo);
			
		}
		
		System.out.println();
		System.out.println("LISTANDO ARQUIVOS");
		System.out.println();
		
		File[] files = pasta.listFiles(File::isFile);
		
		for ( File arquivo : files  ) {
			
			System.out.println(arquivo);
			
		}
		
		
		System.out.println();
		System.out.println("CRIANDO UMA PASTA");
		System.out.println();
		
		if ( new File("c:\\temp\\aulajava").mkdir() ) {
			System.out.println("Pasta criada com sucesso");
		}
		else {
			System.out.println("Nao foi possivel criar pasta");
		}

	}

}
