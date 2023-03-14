package br.com.udemy.java.secao14.entities;

import java.text.SimpleDateFormat;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/yyyy");
		return this.getName() + "(used) $ " + 
				String.format("%.2f", this.getPrice()) + 
				" (Manufacture date: $ "+sdf.format(this.getManufactureDate()) +")";
	}
	
	
}
