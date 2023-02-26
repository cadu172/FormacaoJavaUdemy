package br.com.udemy.java.secao13.entities;

import java.util.Date;

public class HourContract {
	
	private Date date;
	private Double valuePerHour;
	private int hours;
	
	public HourContract(Date date, Double valuePerHour, int hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}
	
	public Double totalValue() {
		return this.hours * this.valuePerHour;
	}

	public Date getDate() {
		return date;
	}
	
	
	
}
