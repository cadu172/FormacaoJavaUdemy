package br.com.udemy.java.secao17;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Aula214LendoArquivoTexto {

	public static void main(String[] args) {
		
		Scanner scan = null;
		File arquivoTexto = new File("c:\\temp\\teste2.txt");
		
		try {
			
			scan = new Scanner(arquivoTexto);
			
			while (  scan.hasNextLine() ) { 
				System.out.println(scan.nextLine());
			}
			
		}
		catch ( IOException e ) {
			System.out.println("Erro ao abrir arquivo texto: " + e.getMessage());
		}
		finally {
			if ( scan != null ) {
				scan.close();
			}
		}

	}

}
