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
		
		PrintService lista = new PrintService();
		
		for(int i=1; i<= quantity; i++) {
			
			Integer value = scan.nextInt();
			
			lista.addValue(value);
		}
		
		lista.print();
		
		scan.close();

	}

}
