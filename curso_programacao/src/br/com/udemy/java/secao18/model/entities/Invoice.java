package br.com.udemy.java.secao18.model.entities;

public class Invoice {
	
	private double basicPayment;
	private double tax;	
	
	public Invoice(double basicPayment, double tax) {		
		this.basicPayment = basicPayment;
		this.tax = tax;
	}

	public double getTotalPayment() {
		return basicPayment + tax;
	}

	public double getBasicPayment() {
		return basicPayment;
	}

	public double getTax() {
		return tax;
	}
	
	
	
}
