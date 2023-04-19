package br.com.udemy.java.secao18.model.entities;

import br.com.udemy.java.secao18.model.enums.Color;

public class Circle extends Shape {


	private Double radius;

	public Circle(Color color, Double radius) {
		super(color);
		this.radius = radius;
	}

	public Double getRadius() {
		return radius;
	}
	
	@Override
	public Double area() {
		return Math.PI * radius * radius;
	}	

}
