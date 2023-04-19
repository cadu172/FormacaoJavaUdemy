package br.com.udemy.java.secao18.model.entities;

import br.com.udemy.java.secao18.model.enums.Color;

public abstract class AbstractShape implements IShape {
	
	private Color color;

	public AbstractShape(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
}
