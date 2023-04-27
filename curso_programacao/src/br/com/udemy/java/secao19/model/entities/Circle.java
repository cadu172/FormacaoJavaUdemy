package br.com.udemy.java.secao19.model.entities;

public final class Circle implements InterfaceShape {
	
	
	private Double radius;
	
	public Circle(Double radius) {	
		this.radius = radius;
	}

	@Override
	public Double area() {
		return Math.PI * this.radius * this.radius;
	}

	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}
	
	

}
