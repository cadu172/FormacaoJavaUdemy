package br.com.udemy.java.secao17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import br.com.udemy.java.secao17.entities.Produto;

public class Aula220ExercicioProposto {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		try ( BufferedReader leitorDeArquivo = new BufferedReader(new FileReader("c:\\temp\\products.csv"))  ) {
			
			String currentLine = leitorDeArquivo.readLine();
			
			while (  currentLine != null ) {
				
				if ( currentLine != "" ) {
					
					Produto produto = new Produto (
								currentLine.split(",")[0],
								Float.parseFloat(currentLine.split(",")[1]),
								Integer.parseInt(currentLine.split(",")[2]));
					

					String newLine = produto.getName() + "," + String.format("%.2f", produto.getTotalValue()) ;
					
					System.out.println(newLine);
				
				}
				
				// proxima linha
				currentLine = leitorDeArquivo.readLine();
				
			}
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}		 

	}

}
