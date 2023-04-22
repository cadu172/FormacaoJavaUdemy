package br.com.udemy.java.secao18;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao18.model.entities.BrazilInterestService;
import br.com.udemy.java.secao18.model.entities.IInterestService;
import br.com.udemy.java.secao18.model.entities.USAInterestService;

public class Aula235InterfaceDefaultMethods {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner scan = new Scanner(System.in);
		
		IInterestService service;
		
		System.out.print("Quantia: ");
		Double valorPrincipal = scan.nextDouble();
		
		System.out.print("Meses: ");
		Integer prazoFinanciamento = scan.nextInt();scan.nextLine();
		
		System.out.print("Local da Taxa de Juros\n[1 - Brazil ou 2 - USA] : ");
		Integer tipoTaxaJuros = scan.nextInt();scan.nextLine();
		
		if ( tipoTaxaJuros == 1 ) {			
			service = new BrazilInterestService();
		}
		else {
			service = new USAInterestService();
		}		
		
		Double valorFinalFinanciamento = service.payment(valorPrincipal, prazoFinanciamento);
		
		System.out.println("Pagamento apos "+prazoFinanciamento+" meses : " + String.format("%.2f", valorFinalFinanciamento));
		
		scan.close();

	}

}
