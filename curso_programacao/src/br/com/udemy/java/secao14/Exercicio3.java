package br.com.udemy.java.secao14;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao14.entities.Contribuinte;
import br.com.udemy.java.secao14.entities.PessoaFisica;
import br.com.udemy.java.secao14.entities.PessoaJuridica;

public class Exercicio3 {

	public static void main(String[] args) {		
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Contribuinte> contribuinteList = new ArrayList<Contribuinte>();
		
		double totalImpostos = 0;
		
		System.out.print("Enter the number of tax payers: ");
		int numeroPagante = scan.nextInt();scan.nextLine();
		
		for ( int item=1; item<=numeroPagante; item++ ) {
			
			System.out.println("Tax payer #"+item+" data: ");
			
			System.out.print("Individual or company (i/c)? ");
			char tipoContribuinte = scan.next().charAt(0);scan.nextLine();
			
			System.out.print("Name: ");
			String nome = scan.nextLine();
			
			System.out.print("Anual income: ");
			double rendaAnual = scan.nextDouble();
			
			if ( (tipoContribuinte == 'i' ) || (tipoContribuinte == 'I' ) ) {
				
				System.out.print("Health expenditures: ");
				double gastosComSaude = scan.nextDouble();
				
				contribuinteList.add(new PessoaFisica(nome, rendaAnual, gastosComSaude));				
				
			}
			else {
				
				System.out.print("Number of employees: ");
				int numeroDeFuncionarios = scan.nextInt();scan.nextLine();
				
				contribuinteList.add(new PessoaJuridica(nome, rendaAnual, numeroDeFuncionarios));
			
			}
			
		}
		
		scan.close();
		
		System.out.println("");		
		System.out.println("");
		System.out.println("TAXES PAID:");
		
		for (Contribuinte contribuinte : contribuinteList) {
			totalImpostos += contribuinte.calcularImposto();
			System.out.println(contribuinte.getNome() + ": $ " + String.format("%.4f", contribuinte.calcularImposto()) );
		}
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", totalImpostos));

	}

}
