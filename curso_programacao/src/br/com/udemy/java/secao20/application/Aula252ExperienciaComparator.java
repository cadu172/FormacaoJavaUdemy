package br.com.udemy.java.secao20.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.udemy.java.secao20.entities.MyComparator;
import br.com.udemy.java.secao20.entities.Product;

public class Aula252ExperienciaComparator {

	public static void main(String[] args) {
		
		List<Product> productList = new ArrayList<>();
		
		productList.add(new Product("TV", 2500.00));
		productList.add(new Product("CELULAR", 5600.00));
		productList.add(new Product("MOUSE", 75.00));
		
		
		/*Comparator<Product> productComparator = new Comparator<Product>() {

			@Override
			public int compare(Product p1, Product p2) {
				// TODO Auto-generated method stub
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
			
		};*/
		
		//Comparator<Product> productComparator = (Product p1, Product p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		
		//Collections.sort(productList);
		//productList.sort(new MyComparator());
		//productList.sort(productComparator);
		
		productList.sort((Product p1, Product p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
		
		for ( Product item : productList ) {
			System.out.println(item);			
		}
		

	}

}
