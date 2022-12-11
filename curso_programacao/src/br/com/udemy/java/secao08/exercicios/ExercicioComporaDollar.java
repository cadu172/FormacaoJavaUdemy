package br.com.udemy.java.secao08.exercicios;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao08.util.CurrencyConverter;

public class ExercicioCompraeDollar {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Qual o valor do dollar? ");
		double precoDollarEmReal = scan.nextDouble();
		
		System.out.print("Quantos dollares voce pretende comprar? ");
		double valorCompraDollar = scan.nextDouble();
		
		System.out.printf("Para comprar %.2f dollares voce pagara %.2f reais\n",valorCompraDollar,CurrencyConverter.calcAmoundPaidInReal(precoDollarEmReal, valorCompraDollar)   );
		
		scan.close();		
		

	}

}
