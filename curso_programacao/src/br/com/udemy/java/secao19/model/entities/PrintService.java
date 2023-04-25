package br.com.udemy.java.secao19.model.entities;

import java.util.ArrayList;
import java.util.List;

public class PrintService<PrintServiceType> {
	
	private List<PrintServiceType> myList = new ArrayList<PrintServiceType>();
	
	public void addValue(PrintServiceType value) {
		this.myList.add(value);
	}
	
	public PrintServiceType first() {
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

			System.out.println("First: " + this.first());
		
		}
		else {
			System.out.println("Lista vazia");
		}
		
	}

}
