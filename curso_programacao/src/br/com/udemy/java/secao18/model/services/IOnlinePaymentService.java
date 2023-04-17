package br.com.udemy.java.secao18.model.services;

public interface IOnlinePaymentService {
	
	public Double paymentFee(Double amount);
	public Double interest(Double amount, Integer months);

}
