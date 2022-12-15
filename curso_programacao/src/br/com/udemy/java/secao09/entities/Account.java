package br.com.udemy.java.secao09.entities;

public class Account {
	
	private int accountNumber;
	private String name;
	private double currentBalance;
	private final double WITHDRAWAL_RATE = 5.00;
	
	public Account(int accountNumber, String name, double openingBallance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.makeDeposit(openingBallance);
	}
	
	public Account(int accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;		
	}
	
	public void makeDeposit(double value) {
		this.currentBalance += value;
	}
	
	public void withDraw(double value) {
		// efetuar o saque da conta
		this.currentBalance -= value + this.WITHDRAWAL_RATE;
	}
	
	public String toString() {
		return String.format("Account %d, Holder: %s, Balance $ %.2f",this.accountNumber, this.name, this.currentBalance);
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

}
