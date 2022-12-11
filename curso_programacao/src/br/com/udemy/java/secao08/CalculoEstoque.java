package br.com.udemy.java.secao08;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao08.entities.Product;

public class CalculoEstoque {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		Product product = new Product();
		
		System.out.println("Enter product data:");
		System.out.print("Name: ");
		product.name = scan.nextLine();
		
		System.out.print("Price: ");
		product.price = scan.nextDouble();
		
		System.out.print("Quantity in stock: ");
		product.quantity = scan.nextInt();
		
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
