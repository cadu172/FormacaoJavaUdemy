package br.com.udemy.java.secao18.model.services;

public class PaypalService implements IOnlinePaymentService {
	
	@Override
	public Double interest(Double amount, Integer months) {
		return amount * (1+(months/100));
	}

	@Override
	public Double paymentFee(Double amount) { 
		return amount * 0.02;
	}	

}
