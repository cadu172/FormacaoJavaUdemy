package br.com.udemy.java.secao14;

import br.com.udemy.java.secao14.entities.Account;
import br.com.udemy.java.secao14.entities.SavingsAccount;

public class Aula160IntroducaoPolimorfismo {

	public static void main(String[] args) {
		
		Account contaPoupanca = new SavingsAccount(41254175, "CP Carlos", 1000.0, 0.05);
		Account contaCorrente = new Account(52147517, "CC Carlos", 1000.0);
		
		contaPoupanca.withDraw(50.0);
		contaCorrente.withDraw(50.0);
		
		System.out.println(contaPoupanca.getBalance());
		System.out.println(contaCorrente.getBalance());

	}

}
