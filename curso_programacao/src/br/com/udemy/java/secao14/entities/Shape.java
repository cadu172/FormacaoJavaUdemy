package br.com.udemy.java.secao14.entities;

import br.com.udemy.java.secao14.entities.enums.Color;

public abstract class Shape {
	
	private Color color;
	
	public Shape(Color color) {
		this.color = color;
	}
	
	public abstract float area(); // este aqui é só uma abstração e não deve ter corpo de implementação

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	

}
