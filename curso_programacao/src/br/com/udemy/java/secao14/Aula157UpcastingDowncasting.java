package br.com.udemy.java.secao14;

import br.com.udemy.java.secao14.entities.BussinessAccount;
import br.com.udemy.java.secao14.entities.SavingsAccount;
import br.com.udemy.java.secao14.entities.Account;

public class Aula157UpcastingDowncasting {

	public static void main(String[] args) {
		
		
		//Upcasting
		// é quando instanciamos uma sub-classe em um objeto da superclasse
		
		/*
		 * Neste exemplo estamos instanciando uma subclasse BussinessAccount em um objeto do tipo Account*/
		Account acc1 = new BussinessAccount(1001, "Conta-PJ CARLOS", 0.0, 1500.0d);
		
		/*
		 * 
		 * Neste exemplo estamos relizando a mesma operação, instanciando uma classe do tipo conta-poupanca em uma superclasse Account*/
		Account acc2 = new SavingsAccount(1002, "Conta-POUPANCA EDUARDA", 0.0d, 0.05d);
		
		
		//Downcasting
		/*
		 * É quando instanciamos uma superclasse em um objeto do tipo subclasse, é o inverso da operação Upcasting*/
		BussinessAccount acc3 = (BussinessAccount)acc1;
		acc3.loan(1200.0);
		
		
		//BussinessAccount acc4 = (BussinessAccount)acc2;
		//acc4.loan(1200.0);
		if ( acc2 instanceof  BussinessAccount ) {
			
			BussinessAccount acc5 = (BussinessAccount)acc2;
			acc5.loan(1200.0);
			System.out.println("Conta Loan");
			
			
		} 
		
		if ( acc2 instanceof  SavingsAccount ) {
			
			SavingsAccount acc5 = (SavingsAccount)acc2;
			// aplicar rendimento de conta-poupança
			acc5.updateBalance();
			System.out.println("Conta update");
			
		} 
		

	}

}
