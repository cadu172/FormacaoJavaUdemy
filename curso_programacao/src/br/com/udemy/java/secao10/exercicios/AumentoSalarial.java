package br.com.udemy.java.secao10.exercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao10.entities.Funcionario;

public class AumentoSalarial {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Quantos Funcionarios Voce fara o registro? ");
			
			int quantidadeFuncionarios = scan.nextInt();
			scan.nextLine();
			
			List<Funcionario> funcionarios = new ArrayList<>();		
			
			
			for(int i=0; i<quantidadeFuncionarios; i++) {
				
				for(;;) {
					
					Boolean jaEstaCadastrado = false;
					
					System.out.println("Funcionario #" + ( i + 1 ) + " :");
					
					System.out.print("id: ");			
					Integer id = scan.nextInt();scan.nextLine();
					
					for(Funcionario item : funcionarios) {
						
						if ( ! ( item == null ) ) {
							if ( item.getId() == id  ) {
								System.out.println("Funcionario ja esta cadastrado, informe outro ID");
								jaEstaCadastrado = true;
								break;
							}						
						}
					}
					
					if ( ! jaEstaCadastrado ) {
						
						System.out.print("Nome: ");			
						String nome = scan.nextLine();
						
						System.out.print("Salario: ");
						Float salario = scan.nextFloat();
						
						funcionarios.add(new Funcionario(id, salario, nome));
						
						break; // sai do loop e vai para o proximo
					
					}					
					
				}
				
			}
			
			Integer idAumento = 0;
			Float percentualAumento ;		 
			
			for(;;) {
			
				
				System.out.print("Informe o ID do Funcionario que recebera o aumento: ");
				
				Integer id = scan.nextInt();scan.nextLine();
				
				Funcionario item = funcionarios.stream().filter(e -> e.getId() == id).findFirst().orElse(null);			
				
				if(item == null) {
					System.out.println("Funcionario nao cadastrado, conferir os ID");
				}
				else {
					System.out.print("Informe o percentual de aumento: ");
					idAumento = id;
					percentualAumento = scan.nextFloat();				
					break;
				}
			}
			

			
			
			System.out.println("\n---- Relatorio de funcionarios -----");		

			
			for(Funcionario item : funcionarios) {
				
				if ( item.getId() == idAumento  ) {
					item.setAumentoSalario(percentualAumento);				
				}
				
				System.out.println(item.toString());
				
			}		
			
			scan.close();
		}		

	}

}
