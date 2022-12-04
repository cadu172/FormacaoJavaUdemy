package br.com.udemy.java.secao06;

import java.util.Scanner;

public class EstruturaRepetitivaWhile {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		
		System.out.print("Digite o proximo valor: ");
		int valorDigitado = scan.nextInt();
		int somaValor = 0;
		
		
		while( valorDigitado != 0 ) {
			
			somaValor += valorDigitado;
			
			System.out.print("Digite o proximo valor: ");
			valorDigitado = scan.nextInt();
			
		}
		
		System.out.println("A soma dos valores digitados eh: " + somaValor);
				
		scan.close();

	}

}
