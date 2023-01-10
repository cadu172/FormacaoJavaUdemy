package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class ExercicioDiagonalMatrizInteiros {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe o tamanho da matriz (colunas x linhas) => ");
		
		// tamanho da matriz informada
		int sizeOfMatrix = scan.nextInt();
		
		// aqui eu faço a declaração de uma matriz multidimensoes
		int[][] minhaMatriz = new int[sizeOfMatrix][sizeOfMatrix];
		
		// quantidade de numeros negativos
		int quantidadeNumerosNegativos = 0;
		
		
		// aqui eu faço a solicitação dos dados para o usuário
		for(int i=0; i<sizeOfMatrix; i++) {
			
			for(int j=0; j<sizeOfMatrix; j++) {
				
				System.out.print("Digite a informacao para a posicao ["+i+" x "+j+"] => ");
				minhaMatriz[i][j] = scan.nextInt();				
				
			}
			
		}
		
		
		System.out.println("\n\nNUMEROS EM DIAGONAL");
		
		
		// aqui eu faço a impressão das colunas nas vertical
		for(int i=0; i<sizeOfMatrix; i++) {
			System.out.print(minhaMatriz[i][i]+" ");
		}
		
		
		// contagem dos numeros negativos na matriz
		for(int i=0; i<sizeOfMatrix; i++) {
			for(int j=0; j<sizeOfMatrix; j++) {
				if( minhaMatriz[i][j] < 0 ) {
					quantidadeNumerosNegativos++;
				}				
			}			
		}
		
		System.out.println("\n\nQUANTIDADE DE NUMEROS NEGATIVOS => " + quantidadeNumerosNegativos);
		
		scan.close();

	}

}
