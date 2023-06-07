package br.com.udemy.java.secao20.util;

import java.util.function.Predicate;

import br.com.udemy.java.secao20.entities.Product;

public class ProductPredicate implements Predicate<Product> {

	@Override
	public boolean test(Product t) {		
		return t.getPrice() >= 1000.00;
	}

}
