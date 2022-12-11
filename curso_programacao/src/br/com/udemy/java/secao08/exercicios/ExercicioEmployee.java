package br.com.udemy.java.secao08.exercicios;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao08.entities.Employee;

public class ExercicioEmployee {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		Employee funcionario = new Employee();
		
		System.out.println(" Entrar com os dados do funcionario ");
		
		System.out.print("Nome: ");
		funcionario.name = scan.nextLine();
		System.out.print("Salario: ");
		funcionario.grossSalary = scan.nextDouble();
		System.out.print("Impostos: ");
		funcionario.tax = scan.nextDouble();
		
		System.out.println("Funcionario: " + funcionario.toString());
		
		System.out.println("");
		
		System.out.print("Qual sera o percentual de aumento do salario? ");
		funcionario.increaseSalary(scan.nextDouble());
		
		System.out.println("Updated data: " + funcionario.toString());
	
		scan.close();

	}

}
