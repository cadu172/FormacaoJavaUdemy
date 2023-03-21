package br.com.udemy.java.secao15;


import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Aula170 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
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
		}
		catch ( InputMismatchException e ) {
			System.out.println("A posicao do array informada deve ser numerica");			
		}
		
		
		System.out.println("fim do programa");
		
		
		scan.close();

	}

}
