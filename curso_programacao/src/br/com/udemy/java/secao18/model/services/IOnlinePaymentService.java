package br.com.udemy.java.secao18.model.services;

public interface IOnlinePaymentService {
	
	public Double paymentFree(Double amount);
	public Double interest(Double amount, Integer months);

}
