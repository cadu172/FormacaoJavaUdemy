package br.com.udemy.java.secao14.entities;

public class BussinessAccount extends Account {
	
	private Double loanLimit;

	public BussinessAccount() {
		super();
		this.loanLimit = 0.0d;
	}

	public BussinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}
	
	
	
	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public void loan(Double amount) {
		
		if ( amount > 0  ) {
			
			if( this.loanLimit >= amount ) {
				
				// depositar emprestimo
				//this.deposit(ammout);
				this.balance += amount;
				
				// remover limite de emprestimo
				this.loanLimit -= amount;
				
				// sacar tarifa
				this.withDraw(10.0d);
				
			}
			
		}
		
	}	
	
}
