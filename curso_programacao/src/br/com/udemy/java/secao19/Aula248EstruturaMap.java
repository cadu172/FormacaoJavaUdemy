package br.com.udemy.java.secao19;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import br.com.udemy.java.secao19.model.entities.Product;

public class Aula248EstruturaMap {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		
		/*Map<String, String> cookies = new HashMap<>();
		
		cookies.put("usuario", "cadu172");
		cookies.put("email", "cadu172@gmail.com");
		cookies.put("celular", "11978451256");
		
		
		//cookies.remove("usuario");
		cookies.put("usuario", "carlos.cadu172");
		
		for ( String item : cookies.keySet()  ) {
			
			System.out.println(item + " -> " + cookies.get(item));
			
		}*/
		
		
		Map<Product, Double> stock = new HashMap<>();
		
		
		Product p1 = new Product("Apple IPhone IV PRO", 14200.0, 100);
		Product p2 = new Product("Samsumg Galaxy S22 FE", 2500.0, 200);
		Product p3 = new Product("XIAOMI Redmi Lite 11", 2500.0, 100);
		
		stock.put(p1, 14200.0);
		stock.put(p2, 14200.0);
		stock.put(p3, 14200.0);
		
		Product iPhone = new Product("Apple IPhone IV PRO", 14200.0, 100);
		
		System.out.println("Contem IPhone:  " + stock.containsKey(iPhone));
		
		for ( Product item : stock.keySet() ) {
			System.out.println(item);
		}		

	}

}
