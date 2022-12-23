package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class PessoaMaisVelha {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("INFORME A QUANTIDADE DE PESSOAS: ");		
		int quantidadePessoa = scan.nextInt();
		
		scan.nextLine();
		
		String vetorNome[] = new String[quantidadePessoa];
		int vetorIdade[] = new int[quantidadePessoa];
		
		int indexMaiorIdade = -1;
		int maiorIdade = -1;
		
		for ( int i = 0; i < vetorNome.length; i++ ) {	
			
			System.out.println("CADASTRO NUMERO => " + ( i  + 1 ));
			
			System.out.print("NOME:");
			vetorNome[i] = scan.nextLine();
			
			System.out.print("IDADE:");
			vetorIdade[i] = scan.nextInt();
			
			scan.nextLine();
			
			if ( vetorIdade[i] >= maiorIdade ) {
				maiorIdade = vetorIdade[i];
				indexMaiorIdade = i;
			}
		}
		
		
		if ( indexMaiorIdade >= 0 ) {
			
			System.out.printf("PESSOA MAIS VELHA: %s COM %d ANOS DE IDADE ",vetorNome[indexMaiorIdade],vetorIdade[indexMaiorIdade]);
			
		}
		else {
			System.out.printf("NENHUM NOME CADASTRADO");
			
		}
		
		scan.close();		

	}

}
