package br.com.udemy.java.secoes_01_02_03_04_05;

import java.util.Scanner;

public class UsandoComandoNext {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String a, b, c;
		
		int d = 0;
		
		
		System.out.println("Digite 3 valores");
		
		d = scan.nextInt();
		scan.nextLine();
		a = scan.nextLine();
		b = scan.nextLine();
		c = scan.nextLine();
		
		System.out.println("Você digitou os seguintes dados:");
		
		System.out.println(d);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);		
		scan.close();
		
	}

}
