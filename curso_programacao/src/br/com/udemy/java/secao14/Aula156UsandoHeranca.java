package br.com.udemy.java.secao14;

import br.com.udemy.java.secao14.entities.BussinessAccount;

public class Aula156UsandoHeranca {

	public static void main(String[] args) {
		
		BussinessAccount account = new BussinessAccount(3073637, "CARLOS EDUARDO DOS SANTOS ROBERTO", 2500.0, 15000.0);
		
		account.loan(3500.0);
		
		System.out.println(account.getBalance());

	}

}
