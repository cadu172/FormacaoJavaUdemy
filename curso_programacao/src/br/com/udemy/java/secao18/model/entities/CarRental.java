package br.com.udemy.java.secao18.model.entities;

import java.time.LocalDateTime;

public class CarRental {

	private LocalDateTime start;
	private LocalDateTime finish;
	private Invoice invoice;
	private Vehicle vehicle;
	
	
	public CarRental(LocalDateTime start, LocalDateTime finish, Vehicle vehicle) {
		
		this.start = start;
		this.finish = finish;		
		this.vehicle = vehicle;
		
	}


	public LocalDateTime getStart() {
		return start;
	}


	public LocalDateTime getFinish() {
		return finish;
	}


	public Invoice getInvoice() {
		return invoice;
	}


	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}

	
	
}
