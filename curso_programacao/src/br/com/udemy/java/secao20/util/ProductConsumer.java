package br.com.udemy.java.secao20.util;

import java.util.function.Consumer;

import br.com.udemy.java.secao20.entities.Product;

public class ProductConsumer implements Consumer<Product> {

	@Override
	public void accept(Product t) {
		t.setPrice(t.getPrice()*1.10);
	}


}
