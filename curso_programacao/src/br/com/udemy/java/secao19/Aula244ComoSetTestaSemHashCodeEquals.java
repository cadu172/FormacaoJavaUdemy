package br.com.udemy.java.secao19;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import br.com.udemy.java.secao19.model.entities.Product;

public class Aula244ComoSetTestaSemHashCodeEquals {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Set<Product> productList = new HashSet<>();
		
		productList.add(new Product("Tablet", 800.0, 10));
		productList.add(new Product("Notebook", 1200.0, 1));
		productList.add(new Product("TV", 900.0, 20));
		
		Product product = new Product("Notebook", 1200.0, 1);

		/*
		 * Este teste vai retornar falso porque a classe Product não tem os métodos HashCode e Equals implementado,
		 * quando estes metodos nao estao implementados o Java faz o teste de igualdade através do endereco de memoria (AREA STACK)
		 * Quando os metodos estao implementados o Java vai implicitamente executar eles e fazer a comparacao
		 * */
		System.out.println(productList.contains(product));
		
		
		//aqui estamos incluindo o objeto product na lista, desta forma o proxmo teste sera true porque ele vai encontrar o objeto na Area Stack
		// obs: desde que os metodos hashCode e equals não estejam ainda implementados
		//productList.add(product);
		//System.out.println(productList.contains(product));

	}

}
