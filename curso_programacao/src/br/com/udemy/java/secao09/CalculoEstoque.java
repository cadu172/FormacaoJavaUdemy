package br.com.udemy.java.secao09;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao09.entities.Product;

public class CalculoEstoque {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
   	    System.out.println("Enter product data:");
		System.out.print("Name: ");
		String name = scan.nextLine();
		
		System.out.print("Price: ");
		double price = scan.nextDouble();
		
		System.out.print("Quantity in stock: ");
		//int quantity = scan.nextInt();
		
		
		//Product product = new Product(name, price, quantity);
		Product product = new Product(name, price); //CONSTRUTOR DA SOBRECARGA
		
		System.out.println("Product data: " + product.toString());
		
		System.out.print("Enter the number of products to be add in stock: ");
		product.addProducts(scan.nextInt());
		System.out.println("Updated data: " + product.toString());
		
		System.out.print("Enter the number of products to be removed in stock: ");
		product.removeProducts(scan.nextInt());
		System.out.println("Updated data: " + product.toString());

		
		scan.close();	

	}

}
