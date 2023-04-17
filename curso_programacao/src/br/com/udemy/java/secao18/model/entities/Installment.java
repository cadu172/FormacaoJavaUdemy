package br.com.udemy.java.secao18.model.entities;

import java.util.Date;

public class Installment {
	
	private Date dueDate;
	private Double ammout;
	
	public Installment(Date dueDate, Double ammout) {	
		this.dueDate = dueDate;
		this.ammout = ammout;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmmout() {
		return ammout;
	}

	public void setAmmout(Double ammout) {
		this.ammout = ammout;
	}

}
