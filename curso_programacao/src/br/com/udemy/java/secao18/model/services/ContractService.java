package br.com.udemy.java.secao18.model.services;

import br.com.udemy.java.secao18.model.entities.Contract;
import br.com.udemy.java.secao18.model.entities.Installment;

public class ContractService {
	
	public void processContract( Contract contract, Integer months ) {
		
		for ( int i = 1; i <= months; i++ ) {
			
			IOnlinePaymentService paymentService = new PaypalService();
			
			Double interestValue = paymentService.interest(contract.getTotalValue(), i); 
			
			Installment installment = new Installment();
			
		}
		
	}

}
