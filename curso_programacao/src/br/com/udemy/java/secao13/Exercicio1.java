package br.com.udemy.java.secao13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao13.entities.Departament;
import br.com.udemy.java.secao13.entities.HourContract;
import br.com.udemy.java.secao13.entities.Worker;
import br.com.udemy.java.secao13.entities.enums.WorkerLevel;

public class Exercicio1 {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		String departamentName;
		String workerName;
		String workerLevel;
		Double workerBaseSalary;
		int quantityContract;
		Date contractDate;
		Double valuePerHour;
		int contractDuration;
		int year;
		int month;
		String dateMMyyyyIncome;
		
		// formatador de data
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Enter department's name: ");		
		departamentName = scan.nextLine();
		
		System.out.println("Enter worker data:");
		
		System.out.print("Name: ");
		workerName = scan.nextLine();
		
		System.out.print("Level: ");
		workerLevel = scan.nextLine();
		
		System.out.print("Base salary: ");
		workerBaseSalary = scan.nextDouble();
		
		
		Worker worker = new Worker(workerName,WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Departament(departamentName));
		
		
		System.out.print("How many contracts to this worker? :");
		quantityContract = scan.nextInt();		
		scan.nextLine();
		
		for (int i = 0; i < quantityContract; i++) {
			
			System.out.println("Enter contract #" + (i+1) +" data: ");
			
			System.out.print("Date (DD/MM/YYYY): ");
			contractDate = formatter.parse(scan.nextLine());
			
			System.out.print("Value per hour: ");
			valuePerHour = scan.nextDouble();
			
			System.out.print("Duration (hours): ");
			contractDuration = scan.nextInt();
			scan.nextLine();			

    		// inclusao do contrato no trabalhador
			worker.addContract(new HourContract(contractDate, valuePerHour, contractDuration));
			
		}		
		
		
		System.out.print("Enter month and year to calculate income (MM/YYYY):");
		dateMMyyyyIncome = scan.nextLine();
		
		month = Integer.parseInt(dateMMyyyyIncome.substring(0, 2));
		year = Integer.parseInt(dateMMyyyyIncome.substring(3));
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartament().getName());
		System.out.println("Income for "+dateMMyyyyIncome+": "+String.format("%.2f", worker.income(year, month)));		
		
		scan.close();	
		

	}

}
