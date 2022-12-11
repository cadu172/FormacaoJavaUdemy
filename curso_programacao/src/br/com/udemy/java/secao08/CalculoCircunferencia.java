package br.com.udemy.java.secao08;

import java.util.Locale;
import java.util.Scanner;
//import br.com.udemy.java.secao08.util.Calculator;
import br.com.udemy.java.secao08.util.CalculatorStatic;

public class CalculoCircunferencia {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);		
		
		Scanner scan = new Scanner(System.in);
		
		//Calculator calc = new Calculator();
		
		System.out.print("Enter Radius: ");
		double radius = scan.nextDouble();
		
		/*System.out.printf("Circumference %.2f\n", calc.circumference(radius));
		System.out.printf("Volume %.2f\n", calc.volume(radius));
		System.out.printf("PI %.4f\n", calc.PI);*/
		
		System.out.printf("Circumference %.2f\n", CalculatorStatic.circumference(radius));
		System.out.printf("Volume %.2f\n", CalculatorStatic.volume(radius));
		System.out.printf("PI %.4f\n", CalculatorStatic.PI);

		
		scan.close();
		
	}

}
