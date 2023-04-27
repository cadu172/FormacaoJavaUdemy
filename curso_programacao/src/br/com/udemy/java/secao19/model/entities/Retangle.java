package br.com.udemy.java.secao19.model.entities;

public final class Retangle implements InterfaceShape {
	
	private Double width;
	private Double height;
	
	
	public Retangle(Double width, Double height) {
		this.width = width;
		this.height = height;
	}


	@Override
	public Double area() {		
		return this.width * this.height;
	}


	public Double getWidth() {
		return width;
	}


	public void setWidth(Double width) {
		this.width = width;
	}


	public Double getHeight() {
		return height;
	}


	public void setHeight(Double height) {
		this.height = height;
	}
	
	
	
}
