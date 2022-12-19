package br.com.udemy.java.secao10.exercicios;

import java.util.Locale;
import java.util.Scanner;

public class ImprimirNumerosReais {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
   	    System.out.print("Quantos numeros voce quer digitar: ");
   	    
   	    int quantidadeNumeros = scan.nextInt();
   	    
   	    float[] numeros = new float[quantidadeNumeros];
   	    float somaNumerosReais = 0;
   	    float mediaNumerosReais = 0;

   	    for (int i = 0; i < quantidadeNumeros; i++) {
   	    	System.out.printf("Digite o numero %d: ", i+1);
   	    	numeros[i] = scan.nextFloat();    	    	
		}
   	    
   	    System.out.print("VALORES: "); 	    
   	    
   	       	    
   	    for (int i = 0; i < quantidadeNumeros; i++) {
   	    	somaNumerosReais += numeros[i]; // SOMA   	    	
   	    	System.out.print(numeros[i] + " "); // IMPRIME QUAL NUMERO ESTÁ SENDO ANALISADO
   	    }
   	    
   	    // CALCULAR A MEDIA
   	    mediaNumerosReais = somaNumerosReais/quantidadeNumeros;   	    
   	    
   	    System.out.println("");
   	    System.out.printf("SOMA: %.2f %n",somaNumerosReais);
   	    System.out.printf("MEDIA: %.2f %n",mediaNumerosReais);
   	    
		scan.close();		
		
	}

}
