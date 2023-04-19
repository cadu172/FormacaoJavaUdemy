package br.com.udemy.java.secao18.model.entities;

import br.com.udemy.java.secao18.model.enums.Color;

public abstract class Shape {
	
	private Color color;
	
	public Shape(Color color) {
	
		this.color = color;
	}

	public abstract Double area();

	public Color getColor() {
		return color;
	}	

}
