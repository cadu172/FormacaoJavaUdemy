package br.com.udemy.java.secao20.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.udemy.java.secao20.entities.Product;

public class Aula261ExercicioStream {

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
				Double preco = Double.parseDouble(arrLinha[1]);
				
				productList.add(new Product (nomeProduto,preco));
				
				linhaAtual = leitorDeArquivo.readLine();
			}
			
			Double valorMedioProduto = productList.stream()
					.map(p -> p.getPrice())
					.reduce(0.00, (x,y) -> x + y) / productList.size();
			
			System.out.println("Average price: " + String.format("%.4f", valorMedioProduto));
			
			Comparator<String> comp = (p1,p2) -> p1.toUpperCase().compareTo(p2.toUpperCase());
			
			List<String> listaAbaixoDaMedia = productList.stream()
						.filter(p -> p.getPrice() < valorMedioProduto)
						.map(p -> p.getName())
						.sorted(comp.reversed())
						.collect(Collectors.toList());			
						
			listaAbaixoDaMedia.forEach(System.out::println);
			

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		scan.close();

	}

}
