package br.com.udemy.java.secao15.model.entities;

import br.com.udemy.java.secao15.model.exceptions.LimiteSaqueExcedidoException;
import br.com.udemy.java.secao15.model.exceptions.SaldoInsuficienteException;

public final class Conta {
	
	private Integer numeroDaConta;
	private String nomeTitular;
	private Double saldo;
	private Double limiteDeSaque;
	
	public Conta(Integer numeroDaConta, String nomeTitular, Double saldo, Double limiteDeSaque) {
		this.numeroDaConta = numeroDaConta;
		this.nomeTitular = nomeTitular;
		this.saldo = saldo;
		this.limiteDeSaque = limiteDeSaque;
	}
	
	public void efetuarSaque(Double valorDoSaque) throws LimiteSaqueExcedidoException,
														SaldoInsuficienteException {
		
		if ( valorDoSaque > this.limiteDeSaque  ) {
			throw new LimiteSaqueExcedidoException("Limite de Saque Excedido");
		}
		else if ( valorDoSaque > this.saldo ) {
			throw new SaldoInsuficienteException("Saldo Insuficiente para Saque");
		}
		else if ( valorDoSaque <= 0  ) {
			throw new IllegalArgumentException("Valor do saque informado nao pode ser negativo ou zero");
		}
		else {
			this.saldo -= valorDoSaque;
		}
		
	}
	
	public void efetuarDeposito(Double valorDoDeposito) {
		if ( valorDoDeposito <= 0 ) {
			throw new IllegalArgumentException("Valor do Deposito informado nao pode ser negativo ou zero");			
		}
		else {
			this.saldo += valorDoDeposito;
		}
	}

	public Double getSaldo() {
		return saldo;
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public Double getLimiteDeSaque() {
		return limiteDeSaque;
	}
	
	
	

}
