package br.com.udemy.java.secao18.model.services;

import java.time.Duration;

import br.com.udemy.java.secao18.model.entities.CarRental;
import br.com.udemy.java.secao18.model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;
	private BrazilTaxService brazilTaxService;
	
	
	
	public RentalService(double pricePerHour, double pricePerDay, BrazilTaxService brazilTaxService) {		
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.brazilTaxService = brazilTaxService;
	}



	public void processInvoice(CarRental carRental) {
		
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes/60.0;
		double basicPayment = 0.0d;
		double tax = 0.0d;
		
		if (  hours <= 12 ) {
			basicPayment = this.pricePerHour * Math.ceil(hours);
		}
		else {
			basicPayment = this.pricePerDay * Math.ceil(hours/24);
		}
		
		tax = brazilTaxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));	
		
	}
	
}
