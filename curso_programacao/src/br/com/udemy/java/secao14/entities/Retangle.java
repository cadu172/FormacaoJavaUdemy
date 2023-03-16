package br.com.udemy.java.secao14.entities;

public final class Retangle extends Shape {
	
	private float width;
	private float height;
	
	public Retangle(float width, float height, String color) {
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
		return 2.0000f;
	}


}
