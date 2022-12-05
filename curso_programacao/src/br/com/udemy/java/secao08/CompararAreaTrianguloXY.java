package br.com.udemy.java.secao08;

import java.util.Locale;
import java.util.Scanner;

public class CompararAreaTrianguloXY {

	public static void main(String[] args) {
		
		/*
		 Aplicação para calculo de área de triangulo
		 Seção 08 - Introdução a Programação Orientada a Objetos		 
		 */		
		
		Locale.setDefault(Locale.US);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Vamos calcular a area de dois triangulos e descobrir qual eh o maior?");
		
		System.out.print("Digite a medida dos três lados do primeiro triangulo, vamos chamar ele de X: ");		
		double a = scan.nextDouble(); 
		double b = scan.nextDouble();
		double c = scan.nextDouble();		
		double p = (a + b + c) / 2.0f;
		double areaX = Math.sqrt( p * (p-a) * (p-b) * (p-c) );		

		System.out.print("Digite a medida dos três lados do segundo triangulo, vamos chamar ele de Y: ");		
		a = scan.nextDouble(); 
		b = scan.nextDouble();
		c = scan.nextDouble();		
		p = (a + b + c) / 2.0f;
		double areaY = Math.sqrt( p * (p-a) * (p-b) * (p-c) );		
		
		if ( areaX >  areaY ) {
			System.out.println("A area do triangulo X eh Maior!");
		}
		else {
			System.out.println("A area do triangulo Y eh Maior!");			
		}
			
		System.out.printf("Medidas do triangulo X => %.4f %n",areaX);
		System.out.printf("Medidas do triangulo Y => %.4f %n",areaY);

		scan.close();

	}

}
