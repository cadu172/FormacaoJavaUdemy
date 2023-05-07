package br.com.udemy.java.secao19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Aula249Exercicio {

	public static void main(String[] args) {
		
		
		Locale.setDefault(Locale.US);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Insira o nome do arquivo: ");
		
		String fileSource = scan.nextLine(); 
		
		try ( BufferedReader reader = new BufferedReader(new FileReader(fileSource)); ) {
			
			Map<String, Integer> apuracaoList = new HashMap<>();
			
			
			String currentLine = reader.readLine();
			
			while ( currentLine != null ) {
				
				String[] arrayLine = currentLine.split(",");
				
				String nomeCandidato = arrayLine[0];
				Integer quantidadeVotos = Integer.parseInt(arrayLine[1]);
				
				//if ( apuracaoList.containsKey(nomeCandidato) ) {
				if ( apuracaoList.get(nomeCandidato) != null  ) {
					apuracaoList.put(nomeCandidato, apuracaoList.get(nomeCandidato)+quantidadeVotos);
				}
				else {
					apuracaoList.put(nomeCandidato, quantidadeVotos);
				}
				
				currentLine = reader.readLine();
			}
			
			for ( String item : apuracaoList.keySet() ) {
				
				System.out.println(item + " -> " + apuracaoList.get(item));
				
			}
			
		}
		catch( IOException e ) {
			System.out.println("Erro ao abrir arquivo: " + e.getMessage());
			e.printStackTrace();
		}
		
		scan.close();
		

	}

}
