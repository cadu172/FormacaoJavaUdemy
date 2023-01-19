package br.com.udemy.java.secoes_01_02_03_04_05;

public class ConversaoDeDados {

	public static void main(String[] args) {
		System.out.println("Exemplo de conversao de dados em JAVA");
		
		int a, b;
		float c;
		
		
		a = 10;
		b = 15;
		c = b/a;
		
		System.out.printf("Primeiro teste = %f %n",c);		
		
		// caso o cast não seja realizado, o resultado da divisão será somente a parte inteira
		c = (float)b/a;
		
		System.out.printf("Segundo teste apos a conversao = %f %n",c);

	}

}
