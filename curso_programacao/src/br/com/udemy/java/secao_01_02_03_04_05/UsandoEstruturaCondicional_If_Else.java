package br.com.udemy.java.secao_01_02_03_04_05;

import java.util.Scanner;

public class UsandoEstruturaCondicional_If_Else {

	public static void main(String[] args) {
		
		Scanner scan =  new Scanner(System.in);
		
		System.out.print("Digite a hora atual: ");
		
		int hora = scan.nextInt();
		
		if ( hora < 12 ) {
			System.out.println("Bom dia, agora sao "+hora+" horas ");
		}
		else if ( hora <= 18 ) {
			System.out.println("Boa tarde, agora sao "+hora+" horas ");
		}
		else {
			System.out.println("Boa noite, agora sao "+hora+" horas ");
		}
			
		scan.close();

	}

}
