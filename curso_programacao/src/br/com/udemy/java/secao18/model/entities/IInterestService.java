package br.com.udemy.java.secao18.model.entities;

public interface IInterestService {
	
	public Double getInterestRate();
	
	public default Double payment( Double amount, Integer months ) {
		return amount * Math.pow(1.0 + this.getInterestRate()/100.0 , months);
	}

}
