package br.com.udemy.java.secao19;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import br.com.udemy.java.secao19.model.entities.Product;

public class Aula245ComoTreeSetComparaOsElementos {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Set<Product> productList = new TreeSet<>();
		
		productList.add(new Product("Tablet", 800.0, 10));
		productList.add(new Product("Notebook", 1200.0, 1));
		productList.add(new Product("TV", 900.0, 20));
		
		for (Product product : productList) {
			System.out.println(product);			
		}
		
		/*
		 * Para a classe TreeSet funcionar é obrigatório que o Objeto que está declarado no Set implemente a interface Comparable
		 * 
		 * */
		
	}

}
