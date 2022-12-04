package br.com.udemy.java.secao06;

import java.util.Scanner;

public class EstruturaRepetitivaFor {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite a quantidade de numeros que serao somados: ");
		
		int N = scan.nextInt();
		
		int somaNumeros = 0;
		
		
		for (int i = 0; i < N; i++) {			
			System.out.print("Digite o numero ("+(i+1)+") => ");
			somaNumeros += scan.nextInt();			
		}
		
		System.out.println("A soma dos numeros digitados eh: " + somaNumeros);
		
		scan.close();

	}

}
