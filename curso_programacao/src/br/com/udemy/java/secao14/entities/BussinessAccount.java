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

	@Override
	public void withDraw(Double amount) {

		/* aqui estamos chamando o método de saque da superclasse, este método não possui a mesma regra de saque de uma conta empresarial
		 * ele fas somente um saque simples sem taxa nenhuma
		 */
		super.withDraw(amount);
		
		// taxa de saque de R$ 5,00 somente em contas empresariais
		this.balance -= 2.0d;
	
	}	
	
	
	
}
