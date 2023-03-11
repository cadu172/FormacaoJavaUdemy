package br.com.udemy.java.secao14.entities;

import java.util.Date;

public final class UsedProduct extends Product{

	private Date manufactureDate;

	public UsedProduct(String name, float price, Date manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public Date getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Date manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return "PriceTag UsedProduct";
	}
	
	
}
