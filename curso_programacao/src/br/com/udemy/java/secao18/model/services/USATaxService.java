package br.com.udemy.java.secao18.model.services;

public class USATaxService implements ITaxService {
	
	public Double tax(Double ammount) {
		
		if ( ammount <= 100 ) {
			return ammount * 0.20;
		}
		
		return ammount * 0.15;
		
	}

}
