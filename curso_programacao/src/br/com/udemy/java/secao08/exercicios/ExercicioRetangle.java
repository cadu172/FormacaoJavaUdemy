package br.com.udemy.java.secao08.exercicios;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao08.entities.Retangle;

public class ExercicioRetangle {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		Retangle ret = new Retangle();
		
		System.out.println("Enter width and height:");		
		ret.width = scan.nextDouble();
		ret.height = scan.nextDouble();
		
		System.out.printf("AREA: %.4f%n", ret.area());
		System.out.printf("PERIMETER: %.4f%n", ret.perimeter());
		System.out.printf("DIAGONAL: %.4f%n", ret.diagonal());	
		
		scan.close();

	}

}
