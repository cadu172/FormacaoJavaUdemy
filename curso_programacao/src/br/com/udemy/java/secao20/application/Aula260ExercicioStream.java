package br.com.udemy.java.secao20.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.udemy.java.secao20.entities.Product;
import br.com.udemy.java.secao20.util.ProductService;

public class Aula260ExercicioStream {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		//System.out.print("Informe o nome do arquivo: ");
		//String fileName = scan.nextLine();		
		String fileName = "c:\\temp\\products.csv";

		try (BufferedReader leitorDeArquivo = new BufferedReader(new FileReader(fileName))) {

			List<Product> productList = new ArrayList<>();
			
			String linhaAtual = leitorDeArquivo.readLine();

			while (linhaAtual != null) {
				
				String[] arrLinha = linhaAtual.split(",");
				
				String nomeProduto = arrLinha[0];
				Double preco = Double.valueOf(arrLinha[1]);
				
				productList.add(new Product (nomeProduto,preco));
				
				linhaAtual = leitorDeArquivo.readLine();
			}
			
			Double valorMedioProduto = ProductService.getAvgOfAllProduct(productList);
			
			System.out.println("Average price: " + String.format("%.4f", valorMedioProduto));
			
			List<Product> listaAbaixoDaMedia = productList.stream().
						filter(p -> p.getPrice() <= valorMedioProduto)						
						.collect(Collectors.toList());
			
			listaAbaixoDaMedia.sort((Product p1, Product p2) -> p2.getName().toUpperCase().compareTo(p1.getName().toUpperCase()));			
			listaAbaixoDaMedia.forEach(System.out::println);
			

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		scan.close();

	}

}
