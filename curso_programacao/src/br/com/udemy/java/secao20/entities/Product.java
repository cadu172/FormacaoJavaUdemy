package br.com.udemy.java.secao20.entities;

public class Product implements Comparable<Product>{
	
	private String name;
	private Double price;
	
	
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public int compareTo(Product prod) {
		// TODO Auto-generated method stub
		return this.getName().toUpperCase().compareTo(prod.getName().toUpperCase());
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	

}
