package br.com.udemy.java.secao10.exercicios;

public class BoxingUnBoxingWrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x = 20;
		
		Object obj = x; // boxing, conversao de um tipo primitivo em Objeto
		
		System.out.print(obj);
		
		int y = (int) x; // processo de unBoxing, conversao de Object para o tipo primitivo
		
		System.out.print(y);
		
		
		Integer w = 26; // Integer é um tipo Wrapper, que é uma variável primitiva em formato de classe com objetivo de usar recursos de OOP
		
		int h = w;
		
		System.out.print(h);

	}

}
