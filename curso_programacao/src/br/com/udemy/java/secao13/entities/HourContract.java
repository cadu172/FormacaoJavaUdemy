package br.com.udemy.java.secao13.entities;

import java.util.Date;

public class HourContract {
	
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	private Double valuePerHour;
	private int hours;	
}
