package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao10.entities.Pessoa;

public class AlturaPessoas {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("PROBLEMA DE CALCULO DA ALTURA E IDADE DE PESSOAS");
		
		System.out.print("Quantas pessoas serao inseridas no grupo? ");
		
		int quantidadePessoas = scan.nextInt();
		
		scan.nextLine();
		
		Pessoa p[] = new Pessoa[quantidadePessoas];
		
		for( int i=0; i<p.length; i++  ) {
			
			System.out.println("DADOS DA " + ( i+1 ) +" PESSOA");
			
			System.out.print("Digite o nome: ");			
			String nome = scan.nextLine();			
			
			System.out.print("Digite a altura: ");
			float altura = scan.nextFloat();
			
			System.out.print("Digite a idade: ");
			int idade = scan.nextInt();
			
			scan.nextLine();
			
			// aqui incluimos a pessoa no array
			p[i] = new Pessoa(nome, idade, altura);			
			
		}
		
		float alturaMediaPessoa = 0.0f;
		int quantidadeMenos16Anos = 0;
		float percentualMenor16Anos = 0.0f;
		
		for (int i=0; i < p.length; i++) {
			alturaMediaPessoa += p[i].getAltura();
			
			if (  p[i].getIdade() < 16 ) {
				quantidadeMenos16Anos += 1;
			}
		}
		
		// calcular altura media das pessoas
		alturaMediaPessoa = alturaMediaPessoa / p.length;
		
		System.out.printf("Altura media %.2f%n", alturaMediaPessoa);
		
		percentualMenor16Anos = (float)quantidadeMenos16Anos/p.length*100;
		
		if ( quantidadeMenos16Anos > 0 ) {
			
			System.out.printf("Pessoas com menos de 16 anos: %.2f%n", percentualMenor16Anos);
			
			for (int i=0; i < p.length; i++) {
				if (  p[i].getIdade() < 16 ) {
					System.out.println(p[i].getNome());
				}
			}
			
		}
		
		scan.close();		
		
	}

}
