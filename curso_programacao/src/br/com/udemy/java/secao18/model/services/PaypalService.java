package br.com.udemy.java.secao18.model.services;

public class PaypalService implements IOnlinePaymentService {
	
	public Double paymentFree(Double amount) {
		return 0.0d;
	}
	
	public Double interest(Double amount, Integer months) {
		return 0.0d;
	}	

}
