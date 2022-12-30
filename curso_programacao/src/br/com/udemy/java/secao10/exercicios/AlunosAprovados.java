package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class AlunosAprovados {

	public static void main(String[] args) {		
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("INFORME A QUANTIDADE DE ALUNOS: ");		

		int quantidadeAlunos = scan.nextInt();
		
		String nomesAlunos[] = new String[quantidadeAlunos];
		float notas1Semestre[] = new float[quantidadeAlunos];
		float notas2Semestre[] = new float[quantidadeAlunos];
		
		for ( int i = 0; i < nomesAlunos.length; i++ ) {
			System.out.print("Digite o nome do aluno: ");
			scan.nextLine();
			nomesAlunos[i] = scan.nextLine();
			System.out.print("Informe a nota do primeiro semestre: ");
			notas1Semestre[i] = scan.nextFloat();
			System.out.print("Informe a nota do segundo semestre: ");
			notas2Semestre[i] = scan.nextFloat();				
		}
		
		
		System.out.println("ALUNOS APROVADOS: ");
		
		for ( int i = 0; i < nomesAlunos.length; i++ ) {
			
			float mediaAluno = ( notas1Semestre[i] + notas2Semestre[i] ) / 2;
			
			if ( mediaAluno >= 6.0 ) {
				System.out.println(nomesAlunos[i]);				
			}
			
		}		
	
	
		scan.close();			
		
		

	}

}
