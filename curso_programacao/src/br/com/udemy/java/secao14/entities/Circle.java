package br.com.udemy.java.secao14.entities;

public final class Circle extends Shape{
	
	private float radius;
	private static final double PI = 3.14159265358979323846;

	public Circle(String color, float radius) {
		super(color);
		this.radius = radius;
	}
	
	@Override
	public float area() {
		return (float)(this.PI*Math.pow(this.radius,2));
	}

	public float getRadius() {
		return this.radius;
	}
	
	

}
