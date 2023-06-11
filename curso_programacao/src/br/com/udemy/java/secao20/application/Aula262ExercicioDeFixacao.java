package br.com.udemy.java.secao20.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.udemy.java.secao20.entities.Funcionario;

public class Aula262ExercicioDeFixacao {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String fileName = scan.nextLine();
		//String fileName = "/Users/carlos/temp/funcionarios.csv";
		
		System.out.print("Enter salary: ");
		Double limitSalary = scan.nextDouble();
		
		System.out.println("Email of people whose salary is more than " + String.format("%.2f", limitSalary) + ": ");		
	
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		
		try( BufferedReader reader = new BufferedReader(new FileReader(fileName)) ) {
			
			String line = reader.readLine();
			
			while ( line != null ) {
				
				String[] arrLine = line.split(",");
				
				listaFuncionario.add(  new Funcionario(arrLine[0],arrLine[1],Double.parseDouble(arrLine[2])) );
				
				line = reader.readLine();
				
			}
			
			
			
			List<String> listaOrdemAlfabetica = listaFuncionario
							.stream()
							.filter(p -> p.getSalary() >= limitSalary)
							.map(p -> p.getEmail())
							.sorted()
							.collect(Collectors.toList());
			
			// imprime a listagem de e-mails de salario acima do especificado pelo usuario
			listaOrdemAlfabetica.forEach(System.out::println);
			
			
			// calcula a soma dos salarios dos funcionarios cujo o nome inicia com a letra M
			Double sumOfSalary = listaFuncionario
					.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary())
					.reduce(0.00, (x, y) -> x + y);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumOfSalary));
			
		}
		catch (  IOException e ) {
			
			System.out.println(e.getMessage());
			
		}
		
		
		scan.close();
		
	}

}
