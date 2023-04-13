package br.com.udemy.java.secao17.entities;

public final class Produto {
	
	private String name;
	private float value;
	private int quantity;
	
	public Produto(String name, float value, int quantity) {
		
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public float getTotalValue() {
		return this.value * this.quantity;
	}

}
