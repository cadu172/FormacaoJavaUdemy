package br.com.udemy.java.secao07;

import java.util.Scanner;

public class OperadoresBitWise {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Digite um numero para verificacao do bit: ");
		int numeroDigitado = scan.nextInt();		
		
		// o sexto bit de 32 é 0
		int numeroComparacao = 32;
		
		// teste com & bit-a-bit
		if ( ( numeroDigitado & numeroComparacao ) != 0 ) {
			System.out.println("Usando operador & (E bit-a-bit) entre "+numeroDigitado+" e "+numeroComparacao+" o resultado eh verdadeiro");
		}
		else {
			System.out.println("Usando operador & (E bit-a-bit) entre "+numeroDigitado+" e "+numeroComparacao+" o resultado eh falso");
		}
		
		// teste com & bit-a-bit
		if ( ( numeroDigitado | numeroComparacao ) != 0 ) {
			System.out.println("Usando operador | (OU bit-a-bit) entre "+numeroDigitado+" e "+numeroComparacao+" o resultado eh verdadeiro");
		}
		else {
			System.out.println("Usando operador | (OU bit-a-bit)entre "+numeroDigitado+" e "+numeroComparacao+" o resultado eh falso");
		}
		
		// teste com & bit-a-bit
		if ( ( numeroDigitado ^ numeroComparacao ) != 0 ) {
			System.out.println("Usando operador ^ (OU exclusivo bit-a-bit) entre "+numeroDigitado+" e "+numeroComparacao+" o resultado eh verdadeiro");
		}
		else {
			System.out.println("Usando operador ^ (OU exclusivo bit-a-bit)entre "+numeroDigitado+" e "+numeroComparacao+" o resultado eh falso");
		}
		
		/*
		 O operador E será verdadeiro quando os dois itens em comparação forem verdadeiros
		 O operador OU será verdadeiro quando qualquer um dos itens em comparação for verdadeiro
		 O operador OU Exclusivo será verdadeiro quando SOMENTE UM dos itens em comparação for verdadeiro
		 */
		
		
		scan.close();		

	}

}
