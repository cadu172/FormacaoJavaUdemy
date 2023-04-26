package br.com.udemy.java.secao19.model.entities;

public final class Product implements Comparable<Product> {
	
	private String name;
	private Double value;
	private int quantity;
	
	public Product(String name, Double value, int quantity) {
		
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Double getTotalValue() {
		return this.value * this.quantity;
	}
	
	@Override
	public String toString() {
		return this.getName() + "," + String.format("%.2f", this.getValue()) ;
	}

	@Override
	public int compareTo(Product other) {		
		return this.value.compareTo(other.getValue());
	}

}
