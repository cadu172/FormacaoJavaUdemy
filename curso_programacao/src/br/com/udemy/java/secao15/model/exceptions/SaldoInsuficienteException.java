package br.com.udemy.java.secao15.model.exceptions;

public class SaldoInsuficienteException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public SaldoInsuficienteException(String message) {
		super(message);
	}
	
}
