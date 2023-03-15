package br.com.udemy.java.secao14.entities;

/*
 * Classe alterada para abstract para testes da aula 163*/
public abstract class Account {
	
	private Integer number;
	private String holder;
	protected Double balance;
	
	public Account() {
		this.balance = 0.0d;
	}

	public Account(Integer number, String holder, Double balance) {		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}


	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void withDraw(Double amount) {
		this.balance -= amount;
		this.balance -= 5.0;
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	

}
