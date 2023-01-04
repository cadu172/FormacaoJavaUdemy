package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao10.entities.Pessoa;

public class DesafioPensionato {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		Pessoa[] quartos = new Pessoa[10];
		
		
		System.out.print("Informe a quantidade de alunos que alugarao os quartos, maximo de 10 alunos: ");
		
		int quantidadeAlunos = scan.nextInt();
		scan.nextLine();
		
		
		for(int i=0; i<quantidadeAlunos; i++) {
			
			System.out.println("Informe os dados do aluno " + ( i + 1 ) + " :");
			
			System.out.print("Nome: ");			
			String nome = scan.nextLine();
			
			System.out.print("E-Mail: ");
			String email = scan.nextLine();
			

			
			for(;;) {
				
				System.out.print("Numero do quarto escolhido: ");
				int numeroQuarto = scan.nextInt();
				scan.nextLine();
				
				if ( numeroQuarto<1 || numeroQuarto>10  ) {
					System.out.println("Numero do quarto precisa estar entre 1 e 10");
				}
				else {
					
					if ( quartos[numeroQuarto-1]==null  ) {
						Pessoa aluno = new Pessoa(nome, email);
						quartos[numeroQuarto-1] = aluno;
						break;
					}
					else {
						System.out.println("Quarto selecionado ja esta ocupado,\ndigite 1 para selecionar outro quarto ou 9 para ir para o priximo aluno");
						int opcao = scan.nextInt();
						if ( opcao==9  ) {
							break;
						}
					}
					
				}
			}
			
		}
		
		System.out.println("---- Relatorio de ocupacao de quartos -----\n");
		
		for(int i=0;i<quartos.length;i++) {
						
			if(! (quartos[i]==null) ) {
				System.out.println(( i + 1 ) + " : " + quartos[i].getNome() + ", " + quartos[i].getEmail());
			};

		}
		
		scan.close();
		
		

	}

}
