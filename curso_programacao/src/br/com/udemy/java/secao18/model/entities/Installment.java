package br.com.udemy.java.secao18.model.entities;

import java.time.LocalDate;

public class Installment {
	
	private LocalDate dueDate;
	private Double ammout;
	
	public Installment(LocalDate dueDate, Double ammout) {	
		this.dueDate = dueDate;
		this.ammout = ammout;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmmout() {
		return ammout;
	}

	public void setAmmout(Double ammout) {
		this.ammout = ammout;
	}
	
	@Override
	public String toString() {		
		return this.getDueDate()  + " - " + String.format("%.2f", this.getAmmout());		
	}

}
