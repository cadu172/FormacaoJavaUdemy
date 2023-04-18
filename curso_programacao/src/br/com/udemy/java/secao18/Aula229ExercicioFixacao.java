package br.com.udemy.java.secao18;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao18.model.entities.Contract;
import br.com.udemy.java.secao18.model.services.ContractService;

public class Aula229ExercicioFixacao {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato:");
				
		System.out.print("Numero: ");
		Integer contractNumber = scan.nextInt();scan.nextLine();
		
		System.out.print("Data (dd/MM/yyyy): ");
		Date contractDate = dateFormatter.parse(scan.nextLine());
		
		System.out.print("Valor do contrato: ");
		Double contractTotalValue = scan.nextDouble();
		
		System.out.print("Entre com o numero de parcelas: ");
		Integer months = scan.nextInt();scan.nextLine();
		
		Contract contract = new Contract(contractNumber, contractDate, contractTotalValue);
		ContractService service = new ContractService();
		
		// processamento das parcelas do contrato
		service.processContract(contract, months);
		
		System.out.println(contract);

		scan.close();

	}

}
