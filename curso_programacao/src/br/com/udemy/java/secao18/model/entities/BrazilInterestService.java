package br.com.udemy.java.secao18.model.entities;

public final class BrazilInterestService implements IInterestService {

	
	private Double interestRate;
	
	
	public BrazilInterestService() {
		this.interestRate = 2.0d;
	} 
	
	public BrazilInterestService(Double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public Double getInterestRate() {
		return interestRate;
	}

}
