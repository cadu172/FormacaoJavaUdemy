package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class AbaixoDaMedia {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("INFORME A QUANTIDADE DE NUMEROS DOS VETORES: ");		

		int quantidadeNumeros = scan.nextInt();
		
		float vetorA[] = new float[quantidadeNumeros];
		float somaElementos = 0.0f;
		float mediaAritmetica = 0.0f;
		
		for ( int i = 0; i < vetorA.length; i++ ) {
			System.out.print("Digite os numeros: ");
			vetorA[i] = scan.nextFloat();
			somaElementos += vetorA[i];
		}
		
		
		mediaAritmetica = somaElementos / vetorA.length;
		
		System.out.println("MEDIA ARITMETICA: " + mediaAritmetica);
		
		System.out.println("ELEMENTOS ABAIXO DA MEDIA: ");
		
		for ( int i = 0; i < vetorA.length; i++ ) {
			if ( vetorA[i] < mediaAritmetica )
			{
				System.out.println(vetorA[i]);
			}
		}		
	
	
		scan.close();			

	}

}
