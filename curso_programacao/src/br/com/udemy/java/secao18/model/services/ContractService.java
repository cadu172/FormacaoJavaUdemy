package br.com.udemy.java.secao18.model.services;

import java.time.LocalDate;

import br.com.udemy.java.secao18.model.entities.Contract;
import br.com.udemy.java.secao18.model.entities.Installment;

public class ContractService {
	
	private IOnlinePaymentService paymentService;
	
	public ContractService(IOnlinePaymentService paymentService) {		
		this.paymentService = paymentService;
	}

	public void processContract( Contract contract, Integer months ) {

		
		LocalDate dataInicial = contract.getDate();
		
		Double amountPerMonth = contract.getTotalValue()/months;
		
		for ( int i = 1; i <= months; i++ ) {
			
			// adicionar um mes a data atual
			dataInicial = dataInicial.plusMonths(1);
			
			// obtem o valor da parcela com taxa de juros
			Double interestValue = paymentService.interest(amountPerMonth, i);
			
			// acrescenta + 2% de taxa de pagamento
			Double paymentFeeValue = paymentService.paymentFee(interestValue);
			
			// valor total da parcela
			Double installmentValue = interestValue+paymentFeeValue;
			
			// nova parcela
			Installment installment = new Installment(dataInicial, installmentValue  );
			
			// incluir nova parcela
			contract.add(installment);
			
		}
		
	}

}
