package br.com.udemy.java.secao20.entities;

import java.util.Comparator;

public final class MyComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
	}

}
