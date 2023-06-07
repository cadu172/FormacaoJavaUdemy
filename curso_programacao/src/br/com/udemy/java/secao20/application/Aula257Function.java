package br.com.udemy.java.secao20.application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.udemy.java.secao20.entities.Product;

public class Aula257Function {

	public static void main(String[] args) {
		
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product("Magic Mouse", 600.00));
		productList.add(new Product("Computador", 150.00));
		productList.add(new Product("Apple IPhone", 4500.00));
		productList.add(new Product("Apple TV", 300.00));
		
		
		// metodo com implementação de interface
		//List<String> stringList = productList.stream().map(new ProductFunction()).collect(Collectors.toList());

		// implementação usando um método statico 
		//List<String> stringList = productList.stream().map(Product::staticUpperCase).collect(Collectors.toList());
		
		// implementação usando um método não statico
		//List<String> stringList = productList.stream().map(Product::nonStaticUpperCase).collect(Collectors.toList());		
		
		// implementação declarando a Function usando expressão Lambda declarada
		//Function<Product, String> prod = p -> p.getName().toUpperCase();
		//List<String> stringList = productList.stream().map(prod).collect(Collectors.toList());
		
		// implementação declarando a Function usando expressão Lambda inline
		List<String> stringList = productList.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		stringList.forEach(System.out::println);
		

	}

}
