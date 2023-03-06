package br.com.udemy.java.secao14.entities;

public class Account {
	
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
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	

}