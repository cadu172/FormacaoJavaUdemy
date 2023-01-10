package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class ExercicioEncontrarNumerosVizinhos {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("------ Informe o tamanho da matriz (linhas x colunas) ------");
		
		// tamanho da matriz informada
		System.out.print("Quantidade de Linhas => ");
		int rows = scan.nextInt();
		
		System.out.print("Quantidade de Colunas => ");
		int cols = scan.nextInt();
		
		// aqui eu faço a declaração de uma matriz multidimensoes
		int[][] minhaMatriz = new int[rows][cols];
		
		// aqui eu faço a solicitação dos dados para o usuário
		for(int i=0; i<rows; i++) {
			
			for(int j=0; j<cols; j++) {
				
				System.out.print("Digite a informacao para a posicao [Linha "+i+"][Coluna "+j+"] => ");
				minhaMatriz[i][j] = scan.nextInt();				
				
			}
			
		}
		
		
		System.out.print("\n\nDigite o numero que voce pretende achar na matriz e mostrar os seus vizinhos => ");
		int numeroAchar = scan.nextInt();
		
		// numeros vizinhos
		int top = -1;
		int left = -1;
		int right = -1;
		int down = -1;
		
		// indica que o numero foi localizado
		boolean numeroEncontrado = false;
		
		// procurar na matriz a primeira correspondencia
		// aqui eu faço a solicitação dos dados para o usuário
		for(int i=0; i<rows; i++) {
			
			for(int j=0; j<cols; j++) {
				
				if( minhaMatriz[i][j] == numeroAchar ) {
					
					if ( i > 0 ) {
						top = minhaMatriz[i-1][j];
					}
					
					if ( i < (rows-1) ) {
						down = minhaMatriz[i+1][j]; 
					}
					
					if ( j > 0 ) {
						left = minhaMatriz[i][j-1];
					}
					
					if ( j < ( cols-1 ) ) {
						right = minhaMatriz[i][j+1];
					}
					
					// indicar queo numero foi encontrado e precisa sair do loop
					numeroEncontrado = true;
					
					break;
				
				}				
				
			}
			
			if(numeroEncontrado) {
				break; // sai do loop principal
			}
			
		}
		
		
		System.out.println("\n\nTop => " + top);		
		System.out.println("Left => " + left);
		System.out.println("Right => " + right);
		System.out.println("Down => " + down);
		
		System.out.println("\nREPRESENTACAO VISUAL\n\n");
		System.out.println("     "+top+" ");
		System.out.println(left+"         "+right);
		System.out.println("     "+down+" ");
		
		scan.close();
	
	
	}

}
