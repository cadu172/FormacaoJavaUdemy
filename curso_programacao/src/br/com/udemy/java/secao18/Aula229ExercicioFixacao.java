package br.com.udemy.java.secao18;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao18.model.entities.Contract;
import br.com.udemy.java.secao18.model.services.ContractService;
import br.com.udemy.java.secao18.model.services.PaypalService;

public class Aula229ExercicioFixacao {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entre os dados do contrato:");
				
		System.out.print("Numero: ");
		Integer contractNumber = scan.nextInt();scan.nextLine();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate contractDate = LocalDate.parse(scan.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.print("Valor do contrato: ");
		Double contractTotalValue = scan.nextDouble();
		
		System.out.print("Entre com o numero de parcelas: ");
		Integer months = scan.nextInt();scan.nextLine();
		
		Contract contract = new Contract(contractNumber, contractDate, contractTotalValue);
		
		//ContractService service = new ContractService();
		
		// processamento das parcelas do contrato
		new ContractService( new PaypalService() ).processContract(contract, months);
		
		System.out.println(contract);

		scan.close();

	}

}
