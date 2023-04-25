package br.com.udemy.java.secao18;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao18.model.entities.PrintService;

public class Aula238Exemplo1 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many values: ");
		Integer quantity = scan.nextInt();scan.nextLine();
		
		PrintService<String> listaString = new PrintService<String>();
		PrintService<Integer> listaInteger = new PrintService<Integer>();
		
		for(int i=1; i<= quantity; i++) {
			
			
			System.out.print("Digite uma string: ");						
			listaString.addValue(scan.nextLine());
			
			System.out.print("Digite um numero: ");						
			listaInteger.addValue(scan.nextInt());
			scan.nextLine();
			
		}
		
		System.out.print("LISTA STRING: ");
		listaString.print();
		
		System.out.println();
		System.out.println();
		
		System.out.print("LISTA INTEGER: ");
		listaInteger.print();		
		scan.close();
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Fim do programa");		

	}

}
