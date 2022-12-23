package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class MediaNumerosPares {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("INFORME A QUANTIDADE DE NUMEROS DOS VETORES: ");		
		int quantidadeNumeros = scan.nextInt();
		
		int vetorNumeroInteiro[] = new int[quantidadeNumeros];
		
		int somaNumeroPar = 0;
		int quantidadeNumeroPar = 0;
		
		System.out.println("Digite os numeros: ");
		
		for ( int i = 0; i < vetorNumeroInteiro.length; i++ ) {	
			
			vetorNumeroInteiro[i] = scan.nextInt();
			
			if ( ( vetorNumeroInteiro[i] % 2 ) == 0 ) {
				somaNumeroPar += vetorNumeroInteiro[i];
				quantidadeNumeroPar++;
			}
		}
		
		if ( quantidadeNumeroPar == 0 ) {
			System.out.println("NENHUM NUMERO PAR");
		}
		else {
			System.out.printf("MEDIA DOS NUMEROS PARES: %.1f ", ( (float)somaNumeroPar/quantidadeNumeroPar  ));
		}	
		
		scan.close();		
		
		
		
	}

}
