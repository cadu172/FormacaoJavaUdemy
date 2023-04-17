package br.com.udemy.java.secao18.model.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.com.udemy.java.secao18.model.entities.Contract;
import br.com.udemy.java.secao18.model.entities.Installment;

public class ContractService {
	
	public void processContract( Contract contract, Integer months ) {
		
		LocalDate dataInicial = contract.getDate().toInstant().atZone( ZoneId.systemDefault() ).toLocalDate() ;
		
		Double amountPerMonth = contract.getTotalValue()/months;
		
		for ( int i = 1; i <= months; i++ ) {
			
			// adicionar um mes a data atual
			dataInicial = dataInicial.plusMonths(1);
			
			IOnlinePaymentService paymentService = new PaypalService(); //operação de upcasting
			
			// obtem o valor da parcela com taxa de juros
			Double interestValue = paymentService.interest(amountPerMonth, i);
			
			// acrescenta + 2% de taxa de pagamento
			Double paymentFeeValue = paymentService.paymentFee(interestValue);
			
			// nova parcela
			Installment installment = new Installment(Date.from(dataInicial.atStartOfDay(ZoneId.systemDefault()).toInstant()), ( interestValue+paymentFeeValue ) );
			
			// incluir nova parcela
			contract.add(installment);
			
		}
		
	}

}
