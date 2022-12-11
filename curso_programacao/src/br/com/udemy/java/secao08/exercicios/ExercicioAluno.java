package br.com.udemy.java.secao08.exercicios;

import java.util.Locale;
import java.util.Scanner;
import br.com.udemy.java.secao08.entities.Student;

public class ExercicioAluno {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		Student aluno = new Student();
		
		System.out.println(" Calcular resultado das provas ");
		
		System.out.print("Nome do aluno: ");
		aluno.nome = scan.nextLine();
		
		System.out.print("digite as 3 notas: ");
		
		aluno.notaA = scan.nextDouble();
		aluno.notaB = scan.nextDouble();
		aluno.notaC = scan.nextDouble();
		
		System.out.println(aluno.resultadoAvaliacao());
	
		scan.close();		
		

	}

}
