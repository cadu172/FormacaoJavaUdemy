package br.com.udemy.java.secoes_01_02_03_04_05;

public class EscopoDeVariaveis {

	public static void main(String[] args) {
		
		double valorProduto = 0 ;
		double valorDesconto = 0;
		
		if ( valorProduto < 20.0 ) {
			valorDesconto = valorProduto * 0.8;
		}
		
		// esta acusando erro porque a variável valorDesconto
		// esta declarada dentro do if() que é o escopo dela.
		
		System.out.println(valorDesconto);

	}

}
