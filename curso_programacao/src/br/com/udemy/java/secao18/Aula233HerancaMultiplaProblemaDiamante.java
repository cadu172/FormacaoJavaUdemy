package br.com.udemy.java.secao18;

import java.util.Locale;

import br.com.udemy.java.secao18.model.entities.Printer;
import br.com.udemy.java.secao18.model.entities.Scanner;

public class Aula233HerancaMultiplaProblemaDiamante {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner("HP 1080");
		
		scanner.processDoc("Carlos.doc");
		System.out.println(scanner.scan());
		
		
		Printer printer = new Printer("EPSON LX300");
		printer.processDoc("Carlos.doc");
		printer.print("Carlos.doc");
		
	}

}
