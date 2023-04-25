package br.com.udemy.java.secao18.model.services;

import java.util.List;

public class CalculationService {
	
	public static Integer max(List<Integer> lista) {

		//return Collections.max(lista);
		
		if ( lista.isEmpty()  ) {
			throw new IllegalArgumentException("O parametro lista esta vazio");
		} 
		
		Integer maxNumber = lista.get(0);
		
		for (Integer numero : lista) {
			
			if ( numero.compareTo(maxNumber) > 0  ) {
				maxNumber = numero;
			}
			
		}
		
		return maxNumber;
		
	}

}
