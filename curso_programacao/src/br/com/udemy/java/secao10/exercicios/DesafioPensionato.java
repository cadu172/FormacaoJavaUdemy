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
						System.out.println("Quarto selecionado já está ocupado, digite 1 para continuar ou 9 para ir para o priximo aluno");
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
			System.out.println("Quarto ["+ (i+1) +"]\n");
			
			if(quartos[i]==null) {
				System.out.println("Quarto VAZIO");
			}
			else {
				
				System.out.println("Nome " + quartos[i].getNome());
				System.out.println("Email " + quartos[i].getEmail());
			};
			
			System.out.println("-----------------------------------\n");
		}
		
		scan.close();
		
		

	}

}
