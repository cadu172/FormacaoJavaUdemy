package br.com.udemy.java.secao14.entities;

public final class Circle extends Shape{
	
	private float radius;

	public Circle(String color, float radius) {
		super(color);
		this.radius = radius;
	}
	
	@Override
	public float area() {
		return 3.0000f;
	}

	public float getRadius() {
		return radius;
	}
	
	

}
