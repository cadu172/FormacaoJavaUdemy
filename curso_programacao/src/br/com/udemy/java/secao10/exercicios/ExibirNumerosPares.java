package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class ExibirNumerosPares {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite a quantidade de numeros: ");		
		int quantidadeNumeros = scan.nextInt();
		
		int numeros[] = new int[quantidadeNumeros];
		int quantidadePares = 0;
		
		for ( int i = 0; i < numeros.length; i++ ) {
			
			System.out.print("Digite o numero [" + ( i + 1 ) +"]: ");
			numeros[i] = scan.nextInt();
			
		}
		
		for ( int i = 0; i < numeros.length; i++ ) { 
			
			if ( ( numeros[i] % 2 ) == 0  ) {
				
				quantidadePares++;
				
				System.out.print(numeros[i] + " ");
				
			}
			
		}
		
		
		System.out.println("\nQuantidade de numeros pares: " + quantidadePares);
		
		scan.close();		

	}

}
