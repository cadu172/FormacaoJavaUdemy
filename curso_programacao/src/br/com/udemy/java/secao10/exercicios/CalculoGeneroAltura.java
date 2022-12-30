package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class CalculoGeneroAltura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Quantas pessoas serao digitadas: ");		

		int quantidadeInformacoes = scan.nextInt();
		scan.nextLine();
		
		char vetorGeneros[] = new char[quantidadeInformacoes];
		float vetorAlturas[] = new float[quantidadeInformacoes];
		int quantidadeMasculino = 0;
		int quantidadeFeminino = 0;
		float maiorAltura = 0;
		float menorAltura = 0;
		float somaAlturaMulheres = 0.0F;
		
		for ( int i = 0; i < vetorGeneros.length; i++ ) {
			
			System.out.print("Genero da "+(i+1)+" Pessoa: ");			
			vetorGeneros[i] = scan.next().charAt(0);
			
			System.out.print("Altura da pessoa: ");
			vetorAlturas[i] = scan.nextFloat();
			
			if ( vetorGeneros[i]=='M'  ) {
				quantidadeMasculino++;
			}
			else {
				somaAlturaMulheres += vetorAlturas[i];
				quantidadeFeminino++;
			}
			
			if( ( vetorAlturas[i] <= menorAltura ) || ( menorAltura == 0 )  ) {
				menorAltura = vetorAlturas[i];
			}
			
			if( ( vetorAlturas[i] >= maiorAltura ) || ( maiorAltura == 0 ) ) {
				maiorAltura = vetorAlturas[i];
			}
			
		
		}
		
		
		System.out.printf("Menor altura: %.2f \n",menorAltura);
		System.out.printf("Maior altura: %.2f \n",maiorAltura);
		System.out.printf("Numero de homens: %d \n",quantidadeMasculino);
		System.out.printf("Media de altura das mulheres: %.4f \n",( somaAlturaMulheres/quantidadeFeminino  ));
	
		scan.close();			
				

	}

}
