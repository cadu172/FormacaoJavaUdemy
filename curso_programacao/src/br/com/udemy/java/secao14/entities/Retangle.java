package br.com.udemy.java.secao14.entities;

import br.com.udemy.java.secao14.entities.enums.Color;

public final class Retangle extends Shape {
	
	private float width;
	private float height;
	
	public Retangle(float width, float height, Color color) {
		super(color);
		this.width = width;
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	
	@Override
	public float area() {
		return this.width*this.height;
	}


}
