package br.com.udemy.java.secao18.model.entities;

import java.util.ArrayList;
import java.util.List;

public class PrintService {
	
	private List<Integer> myList = new ArrayList<Integer>();
	
	public void addValue(Integer value) {
		this.myList.add(value);
	}
	
	public Integer first() {
		return this.myList.get(0);
	}
	
	public void print() {
		
		if ( ! this.myList.isEmpty() ) {
		
			System.out.print("[");
			
			for (int i=0; i<this.myList.size(); i++) {
				
				System.out.print(this.myList.get(i));
				
				if ( i < myList.size()-1 ) {
					System.out.print(",");
				}
				
			}
			
			System.out.println("]");		

			System.out.println("First: " + this.myList.get(0));
		
		}
		else {
			System.out.println("Lista vazia");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Fim do programa");
		
	}

}
