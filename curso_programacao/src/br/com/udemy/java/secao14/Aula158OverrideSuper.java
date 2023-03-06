package br.com.udemy.java.secao14;

import br.com.udemy.java.secao14.entities.Account;
import br.com.udemy.java.secao14.entities.BussinessAccount;
import br.com.udemy.java.secao14.entities.SavingsAccount;

public class Aula158OverrideSuper {

	public static void main(String[] args) {
		
		Account contaPadrao = new Account(100, "CONTA PADRAO - carlos", 1000.0);
		contaPadrao.withDraw(200.0);		
		System.out.println("Saldo Conta Padrao: " + String.format("%.2f", contaPadrao.getBalance())  );

		Account contaPoupanca = new SavingsAccount(100, "CONTA PADRAO - carlos", 1000.0, 0.05);
		contaPoupanca.withDraw(200.0);		
		System.out.println("Saldo Conta Popanca: " + String.format("%.2f", contaPoupanca.getBalance())  );

		
		Account contaEmpresa = new BussinessAccount(100, "CONTA PADRAO - carlos", 1000.0, 2500.0);
		contaEmpresa.withDraw(200.0);		
		System.out.println("Saldo Conta Empresa: " + String.format("%.2f", contaEmpresa.getBalance())  );
		
	
	}

}
