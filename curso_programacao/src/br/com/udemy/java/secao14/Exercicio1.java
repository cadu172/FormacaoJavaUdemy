package br.com.udemy.java.secao14;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import br.com.udemy.java.secao14.entities.Employee;
import br.com.udemy.java.secao14.entities.OutsourcedEmployee;

public class Exercicio1 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		int numberOfEmployee = 0;
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		System.err.print("Enter the number of employees: ");
		numberOfEmployee = scan.nextInt();scan.nextLine();
		
		for(int i=1;i<=numberOfEmployee;i++) {
			
			System.out.println("Employee #"+i+" data:");
			
			System.out.print("Outsourced (y/n)? ");
			char outsorcedEmployee = scan.next().charAt(0);
			scan.nextLine();
			 
			System.out.print("Name: ");
			String employeeName = scan.nextLine();

			System.out.print("Hours: ");
			int workedHours = scan.nextInt();
			scan.nextLine();					
			
			System.out.print("Value per hour: ");
			float valuePerHour = scan.nextFloat();			
			
			if ( ( outsorcedEmployee == 'Y' ) || (  outsorcedEmployee == 'y'  ) ) {
				
				System.out.print("Additional charge: ");
				float additionalCharge = scan.nextFloat();
			
				employeeList.add(new OutsourcedEmployee(employeeName, workedHours, valuePerHour, additionalCharge));

			}
			else {
				employeeList.add(new Employee(employeeName, workedHours, valuePerHour));
			}
			
		}
		
		System.out.println("PAYMENTS: ");
		
		for (Employee employee : employeeList) {
			System.out.println(employee.getNome()+" - $" + String.format("%.2f", employee.payment()));
		}
		
		scan.close();
		
	}

}
