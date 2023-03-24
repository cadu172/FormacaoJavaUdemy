package br.com.udemy.java.secao15.model.exceptions;

public class LimiteSaqueExcedidoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public LimiteSaqueExcedidoException(String message) {
		super(message);
	}
	
}
