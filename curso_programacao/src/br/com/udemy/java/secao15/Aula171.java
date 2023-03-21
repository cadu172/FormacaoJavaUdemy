package br.com.udemy.java.secao15;


import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Aula171 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		System.out.println("Main - Inicio do Programa");
		funcao1() ;
		System.out.println("Main - fim do programa");
		
		
		

	}
	
	public static void funcao1() {
		System.out.println("*** Funcao 1 Iniciada ***");
		funcao2() ;
		System.out.println("*** Funcao 1 Finalizada ***");
	}
	
	public static void funcao2() {
		System.out.println("*** Funcao 2 Iniciada ***");
		
		Scanner scan = new Scanner(System.in);
		
		String[] arrayNomes;
		
		System.out.print("digite 3 nomes: ");
		String linha = scan.nextLine();
		
		arrayNomes = linha.split(" ");
		
		try {
			System.out.print("Informe a posicao do array: ");
			int indexArray = scan.nextInt();
			System.out.println(arrayNomes[indexArray]); 
		}
		catch ( ArrayIndexOutOfBoundsException e ) {
			System.out.println("Numero de Posicao do array invalida");
			e.printStackTrace();
		}
		catch ( InputMismatchException e ) {
			System.out.println("A posicao do array informada deve ser numerica");			
		}
		
		scan.close();		
		
		System.out.println("*** Funcao 2 Finalizada ***");
	}
	

}
