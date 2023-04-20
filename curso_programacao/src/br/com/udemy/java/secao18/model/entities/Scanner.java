package br.com.udemy.java.secao18.model.entities;

public class Scanner extends Device {

	
	
	public Scanner(String serialNumber) {
		super(serialNumber);		
	}

	@Override
	public void processDoc(String doc) {
		System.out.println("Scanner Process: " + doc);
	}
	
	public String scan() {
		return "Scanner document complete";
	}	

}
