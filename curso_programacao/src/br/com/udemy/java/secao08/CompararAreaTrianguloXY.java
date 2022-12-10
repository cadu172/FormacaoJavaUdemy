package br.com.udemy.java.secao08;

import java.util.Locale;
import java.util.Scanner;
import br.com.udemy.java.secao08.entities.Triangle;

public class CompararAreaTrianguloXY {

	public static void main(String[] args) {
		
		/*
		 Aplicação para calculo de área de triangulo
		 Seção 08 - Introdução a Programação Orientada a Objetos		 
		 */		
		
		Locale.setDefault(Locale.US);
		
		Scanner scan = new Scanner(System.in);
		
		Triangle trianguloX = new Triangle();
		Triangle trianguloY = new Triangle();
		
		System.out.println("Vamos calcular a area de dois triangulos e descobrir qual eh o maior?");
		
		System.out.print("Digite a medida dos três lados do primeiro triangulo, vamos chamar ele de X: ");		
		trianguloX.a = scan.nextDouble(); 
		trianguloX.b = scan.nextDouble();
		trianguloX.c = scan.nextDouble();		
		
		double areaX = trianguloX.area();		

		System.out.print("Digite a medida dos três lados do segundo triangulo, vamos chamar ele de Y: ");		
		trianguloY.a = scan.nextDouble(); 
		trianguloY.b = scan.nextDouble();
		trianguloY.c = scan.nextDouble();		
		
		double areaY = trianguloY.area();		
		
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
