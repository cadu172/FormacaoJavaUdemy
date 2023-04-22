package br.com.udemy.java.secao18;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Aula234InterfaceComparable {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		try (BufferedReader leitorDeBuffer = new BufferedReader( new FileReader("c:\\temp\\nomes.csv") )) {
			
			String currentLine = leitorDeBuffer.readLine();
			List<String> listaEmployee = new ArrayList<>();
			
			while ( currentLine != null ) {				
				listaEmployee.add(currentLine);				
				currentLine = leitorDeBuffer.readLine();				
			}
			
			Collections.sort(listaEmployee);
			
			for (String nome : listaEmployee) {
				System.out.println(nome);
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
