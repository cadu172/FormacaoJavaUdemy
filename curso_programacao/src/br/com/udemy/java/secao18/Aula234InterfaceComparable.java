package br.com.udemy.java.secao18;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import br.com.udemy.java.secao18.model.entities.Employee;

public class Aula234InterfaceComparable {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		try (BufferedReader leitorDeBuffer = new BufferedReader( new FileReader("c:\\temp\\salary.csv") )) {
			
			String currentLine = leitorDeBuffer.readLine();
		
			List<Employee> listaEmployee = new ArrayList<>();
			
			while ( currentLine != null ) {				
				
				String[] fields = currentLine.split(",");
				
				listaEmployee.add( new Employee(fields[0], Double.parseDouble(fields[1])) );				
				
				currentLine = leitorDeBuffer.readLine();				
			}
			
			Collections.sort(listaEmployee);
			
			for (Employee employee : listaEmployee) {
				System.out.println(employee.getName() + ", " + String.format("%.2f", employee.getSalary()) );
			}
			
		}
		catch ( FileNotFoundException e ) {
			System.out.println("Arquivo nao encontrado");
			e.printStackTrace();
		}
		catch ( IOException e ) {			
			System.out.println("Excecao de IO");
			e.printStackTrace();		
		}		

	}

}
