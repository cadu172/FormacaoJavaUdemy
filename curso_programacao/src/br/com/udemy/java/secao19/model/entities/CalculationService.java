package br.com.udemy.java.secao19.model.entities;

import java.util.List;

public class CalculationService {
	
	//public static <TipoLista extends Comparable<? super TipoLista>> TipoLista max(List<TipoLista> lista) {
	public static <TipoLista extends Comparable<TipoLista>> TipoLista max(List<TipoLista> lista) {

		if ( lista.isEmpty()  ) {
			throw new IllegalArgumentException("O parametro lista esta vazio");
		} 
		
		TipoLista maxNumber = lista.get(0);
		
		for (TipoLista numero : lista) {
			
			if ( numero.compareTo(maxNumber) > 0  ) {
				maxNumber = numero;
			}
			
		}
		
		return maxNumber;
		
	}

}
