package br.com.udemy.java.secao18.model.entities;

public class Printer extends Device {
	
	public Printer(String serialNumber) {
		super(serialNumber); 
	}

	@Override
	public void processDoc(String doc) {
		System.out.println("Printing Process: " + doc);
	}
	
	public void print(String doc) {
		System.out.println("Printing document complete: " + doc);
	}		

}
