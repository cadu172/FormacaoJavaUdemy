package br.com.udemy.java.secao20.application;

import java.util.ArrayList;
import java.util.List;

import br.com.udemy.java.secao20.entities.Product;

public class Aula255Predicate {

	public static void main(String[] args) {
		
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product("Magic Mouse", 600.00));
		productList.add(new Product("Computador", 150.00));
		productList.add(new Product("Apple IPhone", 4500.00));
		productList.add(new Product("Apple TV", 300.00));
		
		double minValue = 1000.00;
		
		//productList.sort(new MyComparator());
		//productList.removeIf(new ProductPredicate());
		//productList.removeIf(Product::staticPredicate);
		//productList.removeIf(Product::nonStaticPredicate);
		productList.removeIf(p -> p.getPrice() >= minValue);
		
		for ( Product item : productList ) {
			System.out.println(item);			
		}

	}

}
