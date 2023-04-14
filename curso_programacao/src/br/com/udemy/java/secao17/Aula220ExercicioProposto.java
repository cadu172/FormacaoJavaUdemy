package br.com.udemy.java.secao17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import br.com.udemy.java.secao17.model.entities.Produto;

public class Aula220ExercicioProposto {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		String fullFilePath = "c:\\temp\\products.csv";
		
		try ( BufferedReader leitorDeArquivo = new BufferedReader(new FileReader(fullFilePath))  ) {
			
			// nome da pasta onde o arquivo está salvo
			String fileParent = (new File(fullFilePath)).getParent();
			
			File newDirectory = new File(fileParent+"\\out");
			
			// criando a nova pasta "out"
			if ( ! newDirectory.isDirectory() ) {
				if ( ! newDirectory.mkdir() ) {
					throw new IOException("Nao foi possivel criar pasta \"out\"");
				}
			}
							
			try (BufferedWriter gravadorDeBuffer = new BufferedWriter(new FileWriter(fileParent + "\\out\\summary.csv") )) {
				
				// obtem a primeira linha do arquivo
				String currentLine = leitorDeArquivo.readLine();
				
				while (  currentLine != null ) {
					
					if ( currentLine != "" ) {
						
						Produto produto = new Produto (
									currentLine.split(",")[0],
									Float.parseFloat(currentLine.split(",")[1]),
									Integer.parseInt(currentLine.split(",")[2]));
						/*
						 * No exemplo do professor ele fez um ArrayList de produtos, passou cada item de produto para a lista e depois
						 * fez um while para o arquivo de saida
						 * No meu caso eu gravei diretamente e aproveitei o mesmo loop e economizei na memoria
						 * */
						
						gravadorDeBuffer.write(produto.toString());
						gravadorDeBuffer.newLine();
					
					}
					
					// proxima linha
					currentLine = leitorDeArquivo.readLine();
					
				}
				
				// fechando o arquivo destino
				gravadorDeBuffer.close();
				
				System.out.println("Arquivo gerado com sucesso");
			
			}
			catch(IOException e) {
				e.printStackTrace();
			}			
			
			// fechando o arquivo de origem
			leitorDeArquivo.close();
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}		 

	}

}
