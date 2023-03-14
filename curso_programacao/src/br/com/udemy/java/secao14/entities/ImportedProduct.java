package br.com.udemy.java.secao14.entities;

public final class ImportedProduct extends Product {
	
	private float customsFee;

	public ImportedProduct(String name, float price, float customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	public float getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(float customsFee) {
		this.customsFee = customsFee;
	}

	@Override
	public String priceTag() {
		return this.getName() + " $ " + 
				String.format("%.2f", this.totalPrice()) + 
				" (Customs fee: $ "+String.format("%.2f", this.getCustomsFee())+")";
	}
	
	public final float totalPrice() {
		return this.getPrice() + this.customsFee;
	}
	
}
