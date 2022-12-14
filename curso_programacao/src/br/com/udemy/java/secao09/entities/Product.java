package br.com.udemy.java.secao09.entities;

public class Product {
	
	private String name;
	private double price;
	private int quantity;
	
	public Product() {
		/* construtor padrao para manter a compatibilidades com outras classes que usam esta entidade mas que não implementaram o codigo de
		chamada ao construtor personalizado
		*/ 
	}
	
	public Product( String name, double price, int quantity ) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product( String name, double price ) {
		/*
		 este construtor é uma sobrecarga do construtor padrão, usamos isso para realizar operacoes nao obrigatorias
		 ao programador mas que precisam ser executadas na criacao do objeto
		 */			
		this.name = name;
		this.price = price;
		this.quantity = 0;
	}
	
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}

	
	public double totalValueInStock() {
		return price * quantity;
	}
	
	public void addProducts(int p_Quantity) {
		this.quantity += p_Quantity;
	}

	public void removeProducts(int p_Quantity) {
		this.quantity -= p_Quantity;
	}
	
	public String toString() {
		return this.name + 
				", $ "+String.format("%.2f", this.price)+
				", " + this.quantity + " units, Total: $ " + String.format("%.2f", this.totalValueInStock());
	}
	
}
