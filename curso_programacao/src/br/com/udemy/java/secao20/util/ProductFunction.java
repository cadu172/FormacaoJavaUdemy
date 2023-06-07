package br.com.udemy.java.secao20.util;

import java.util.function.Function;

import br.com.udemy.java.secao20.entities.Product;

public class ProductFunction implements Function<Product, String> {

	@Override
	public String apply(Product prod) {		
		return prod.getName().toUpperCase();
	}

	
}
