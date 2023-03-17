package br.com.udemy.java.secao14.entities;

import br.com.udemy.java.secao14.entities.enums.Color;

public final class Circle extends Shape{
	
	private float radius;
	private final double PI = 3.14159265358979323846;

	public Circle(Color
			color, float radius) {
		super(color);
		this.radius = radius;
	}
	
	@Override
	public float area() {
		return (float)(this.PI * this.radius * this.radius);
	}

	public float getRadius() {
		return this.radius;
	}
	
	

}
