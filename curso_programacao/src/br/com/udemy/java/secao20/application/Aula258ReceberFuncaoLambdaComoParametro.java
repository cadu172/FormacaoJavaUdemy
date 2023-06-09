package br.com.udemy.java.secao20.application;

import java.util.ArrayList;
import java.util.List;

import br.com.udemy.java.secao20.entities.Product;
import br.com.udemy.java.secao20.util.ProductService;

public class Aula258ReceberFuncaoLambdaComoParametro {

	public static void main(String[] args) {
		
		List<Product> productList = new ArrayList<Product>();
		
		productList.add(new Product("Magic Mouse", 600.00));
		productList.add(new Product("Computador", 150.00));
		productList.add(new Product("Apple IPhone", 4500.00));
		productList.add(new Product("Apple TV", 300.00));
		
		
		double sum = ProductService.getSumOfProduct(productList, p->p.getName().charAt(0)=='A');
		
		System.out.printf("Sum = %.4f", sum);
		

	}

}
