package br.com.udemy.java.secao19.model.entities;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(name, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && Objects.equals(value, other.value);
	}
	
}
