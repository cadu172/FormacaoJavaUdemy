package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class SomaVetores {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("INFORME A QUANTIDADE DE NUMEROS DOS VETORES: ");		
		int quantidadeNumeros = scan.nextInt();
		
		int vetorA[] = new int[quantidadeNumeros];
		int vetorB[] = new int[quantidadeNumeros];
		int vetorC[] = new int[quantidadeNumeros];
		
		
		System.out.println("Digite os numeros do vetor A: ");
		
		for ( int i = 0; i < vetorA.length; i++ ) {	
			vetorA[i] = scan.nextInt();
		}
		
		System.out.println("Digite os numeros do vetor B: ");
		
		for ( int i = 0; i < vetorA.length; i++ ) {	
			vetorB[i] = scan.nextInt();
			vetorC[i] = vetorA[i] + vetorB[i];
		}
		
		
		System.out.println("VETOR RESULTANTE");
		
		for ( int i = 0; i < vetorC.length; i++ ) {			
			System.out.println("vetorC["+i+"] => " + vetorC[i]);			
		}
	
		
		scan.close();		
		
		
	}

}
