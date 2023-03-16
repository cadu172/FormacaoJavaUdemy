package br.com.udemy.java.secao14.entities;

public abstract class Shape {
	
	private String color;
	
	public Shape() {		
	}
	
	public Shape(String color) {
		this.color = color;
	}
	
	public float area() {
		return 1.0000f;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	

}
