package br.com.udemy.java.secao07;

import java.util.Scanner;

public class CriandoFuncoes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite 3 numeros inteiros para saber o maior");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		showMax(max(a,b,c));
		
		scan.close();
		

	}
	
	public static int max(int a, int b, int c) {
		
		int maior = 0;
		
		if ( a > b && a > c ) {
			maior = a;
		}
		else if ( b > a && b > c ) {
			maior = b;
		}
		else {
			maior = c;
		}
		
		return maior;
		
	}
	
	public static void showMax(int valor) {
		System.out.println("O Maior valor informado eh => " + valor);
	}

}
