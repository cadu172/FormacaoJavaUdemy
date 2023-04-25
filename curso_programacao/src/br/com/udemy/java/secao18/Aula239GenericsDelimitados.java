package br.com.udemy.java.secao18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.udemy.java.secao18.model.services.CalculationService;

public class Aula239GenericsDelimitados {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		try ( BufferedReader bufferReader = new BufferedReader(new FileReader("c:\\temp\\numeros.txt")) ) {
			
			String linha = bufferReader.readLine();
			
			List<Integer> lista = new ArrayList<Integer>();
			
			while (  linha != null ) {
				
				System.out.println(linha);				
				
				lista.add(Integer.parseInt(linha));
				
				linha = bufferReader.readLine();				
			}
			
			System.out.println("Maior numero da lista: " + CalculationService.max(lista));
			
		}
		catch ( IOException e ) {
			
			System.out.println("Falha ao abrir arquivo: " + e.getMessage());
			System.out.println("Aplicacao Finalizada");
			
			
		}
		
	}

}
