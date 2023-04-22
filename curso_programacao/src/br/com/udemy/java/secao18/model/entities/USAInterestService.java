package br.com.udemy.java.secao18.model.entities;

public final class USAInterestService implements IInterestService {

	
	private Double interestRate;
	
	public USAInterestService() {
		this.interestRate = 1.0d;
	}	
	
	public USAInterestService(Double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public Double getInterestRate() {
		return interestRate;
	}

}
