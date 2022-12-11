package br.com.udemy.java.secao08.entities;

public class Product {
	
	public String name;
	public double price;
	public int quantity;
	
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
