package com.educandoweb.course.services.exceptions;

public class CarlosException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CarlosException(String mensagem) {
		super("Erro - " + mensagem);
	}

}
