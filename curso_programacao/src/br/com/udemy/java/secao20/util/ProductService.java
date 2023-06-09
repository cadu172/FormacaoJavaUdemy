package br.com.udemy.java.secao20.util;

import java.util.List;
import java.util.function.Predicate;

import br.com.udemy.java.secao20.entities.Product;

public class ProductService {
	
	public static double getSumOfProduct( List<Product> list, Predicate<Product> condicao ) {
		
		double sum = 0.00;
		
		for ( Product item : list ) {
			//if (  item.getName().charAt(0)=='A' ) {
			if ( condicao.test(item)  ) {
				sum += item.getPrice();
			}
		}
		
		return sum;
		
	}

}
