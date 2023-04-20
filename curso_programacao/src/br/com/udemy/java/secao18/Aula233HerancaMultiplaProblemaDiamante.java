package br.com.udemy.java.secao18;

import java.util.Locale;

import br.com.udemy.java.secao18.model.entities.ComboDevice;

public class Aula233HerancaMultiplaProblemaDiamante {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		ComboDevice device = new ComboDevice("HP SmartTank 517 Series");
		
		System.out.println(device.getSerialNumber());
		
		System.out.println();
		
		device.processDoc("Carlos.doc");
		
		System.out.println("Processo Scanner: " + device.scan());
	
		device.print("Carlos.doc");
		
	}

}
