package br.com.udemy.java.secao14;

import java.util.Locale;

import br.com.udemy.java.secao14.entities.Account;
import br.com.udemy.java.secao14.entities.SavingsAccount;
import br.com.udemy.java.secao14.entities.BussinessAccount;

public class Aula163ClassesAbstratas {
	
	public static void main(String[] args) {		
		
		Locale.setDefault(Locale.US);
		
		// a classe Account não pode ser instanciada porque é uma classe abstrata
		Account contaCorrente = new Account(3073637, "C/C CARLOS", 4800.27);
		Account contaPoupanca = new SavingsAccount(10221625, "C/P CARLOS", 120.00, 0.05);
		Account contaEmpresa = new BussinessAccount(10221625, "C/E CARLOS ME", 85000.00, 35000.00);		
		
		System.out.println("Saldo em conta-corrente: $ " + String.format("%.2f", contaCorrente.getBalance()));
		System.out.println("Saldo em conta-poupanca: $ " + String.format("%.2f", contaPoupanca.getBalance()));
		System.out.println("Saldo em conta-empresa: $ " + String.format("%.2f", contaEmpresa.getBalance()));		
		
	}

}
