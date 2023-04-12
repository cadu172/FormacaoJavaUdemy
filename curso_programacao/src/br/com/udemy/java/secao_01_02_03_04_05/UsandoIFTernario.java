package br.com.udemy.java.secao_01_02_03_04_05;

public class UsandoIFTernario {

	public static void main(String[] args) {
		
		double preco = 20.0;
		double precoComDesconto = 0.0;
		
		if ( preco < 30.0 ) {
			precoComDesconto = preco * (1 - 0.25);
		}
		else {
			precoComDesconto = preco * (1 - 0.05);
		}
		
		System.out.println("Preco com desconto = " + precoComDesconto);
		
		// Esta express
		precoComDesconto = (preco < 15.0f) ? preco*(1-0.25) : preco*(1-0.05);
		
		System.out.println("Preco com desconto = " + precoComDesconto);
		
	}

}
