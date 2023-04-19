package br.com.udemy.java.secao18.model.entities;

import br.com.udemy.java.secao18.model.enums.Color;

public class Retangle extends AbstractShape {
	
	private Double width;
	private Double height;
	
	public Retangle(Color color, Double width, Double height) {
		super(color);
		this.width = width;
		this.height = height;
	}

	public Double getWidth() {
		return width;
	}

	public Double getHeight() {
		return height;
	}
	
	@Override
	public Double area() {
		return this.width*this.height;
	}

}
