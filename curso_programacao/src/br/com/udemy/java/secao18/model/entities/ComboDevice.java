package br.com.udemy.java.secao18.model.entities;

public class ComboDevice extends Device implements IScanner, IPrinter {

	public ComboDevice(String serialNumber) {
		super(serialNumber);		
	}

	public void processDoc(String doc) {
		System.out.println("Processando documento: " + doc);		
	}
	
	@Override
	public void print(String doc) {
		System.out.println("Printing document complete: " + doc);
	}
	
	@Override
	public String scan() {
		return "Scanner document complete";
	}	

}
