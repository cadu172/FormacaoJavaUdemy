package br.com.udemy.java.secao19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.udemy.java.secao19.model.entities.CalculationService;
import br.com.udemy.java.secao19.model.entities.Product;

public class Aula239GenericsDelimitados {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		try ( BufferedReader bufferReader = new BufferedReader(new FileReader("c:\\temp\\products.csv")) ) {
			
			String linha = bufferReader.readLine();
			
			List<Product> lista = new ArrayList<Product>();
			
			while (  linha != null ) {
				
				String[] arrayProduto = linha.split(",");
				
				lista.add( new Product(arrayProduto[0], Double.parseDouble(arrayProduto[1])  , Integer.parseInt(arrayProduto[2])) );
				
				linha = bufferReader.readLine();				
			}
			
			Product produto = CalculationService.max(lista);
			
			System.out.println("Produto mais caro da Lista: " + produto);
			
		}
		catch ( IOException e ) {
			
			System.out.println("Falha ao abrir arquivo: " + e.getMessage());
			System.out.println("Aplicacao Finalizada");
			
			
		}
		
	}

}
