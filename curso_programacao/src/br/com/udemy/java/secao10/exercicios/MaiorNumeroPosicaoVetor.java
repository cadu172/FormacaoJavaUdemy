package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class MaiorNumeroPosicaoVetor {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("DIGITE A QUANTIDADE DE NUMEROS PARA ARMAZENAMENTO: ");
		int quantidadeNumeros = scan.nextInt();
		
		float numeros[] = new float[quantidadeNumeros];
		float maiorNumero = -1;
		int posicaoVetor = 0;
		
		for ( int i = 0; i < numeros.length; i++) {
			
			System.out.print("Digite o numero [" + ( i + 1 ) +"]: ");
			
			numeros[i] = scan.nextFloat();
			
			if ( numeros[i] > maiorNumero  ) {
				
				maiorNumero = numeros[i];
				
				posicaoVetor = i;
				
			}
			
		}
		
		System.out.println("\nMAIOR NUMERO: " + maiorNumero);		
		System.out.println("\nPOSICAO DO MAIOR VALOR: " + posicaoVetor);
		
		scan.close();
		
		
	}

}
