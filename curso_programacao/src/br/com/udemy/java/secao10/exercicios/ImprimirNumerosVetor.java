package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class ImprimirNumerosVetor {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
   	    System.out.print("Quantos numeros voce quer digitar: ");
   	    
   	    int quantidadeNumeros = scan.nextInt();
   	    
   	    int[] numeros = new int[quantidadeNumeros];

   	    for (int i = 0; i < quantidadeNumeros; i++) {
   	    	System.out.printf("Digite o numero %d: ", i+1);
   	    	numeros[i] = scan.nextInt();    	    	
		}
   	    
   	    System.out.println("NUMEROS NEGATIVOS:");
   	    
   	    
   	    for (int i = 0; i < quantidadeNumeros; i++) {

   	    	if ( numeros[i] < 0 ) {
   	    		System.out.printf("%d %n", numeros[i]);
   	    	}
		
   	    }
		
		scan.close();		
		
	}

}
