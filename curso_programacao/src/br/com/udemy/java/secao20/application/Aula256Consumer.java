package br.com.udemy.java.secao20.application;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import br.com.udemy.java.secao20.entities.Product;

public class Aula256Consumer {

	public static void main(String[] args) {
		
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product("Magic Mouse", 600.00));
		productList.add(new Product("Computador", 150.00));
		productList.add(new Product("Apple IPhone", 4500.00));
		productList.add(new Product("Apple TV", 300.00));
		
		double fatorUpdate = 1.10;
		
		//productList.sort(new MyComparator());		
		//productList.forEach(new ProductConsumer());
		//productList.forEach(Product::staticUpdatePrice);
		//productList.forEach(Product::nonStaticUpdatePrice);		
		//Consumer<Product> productConsumer = p -> p.setPrice(p.getPrice()*fatorUpdate);
		//productList.forEach(productConsumer);
		productList.forEach(p -> p.setPrice(p.getPrice()*fatorUpdate));
		
		productList.forEach(System.out::println);

	}

}
