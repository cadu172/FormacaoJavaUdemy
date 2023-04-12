package br.com.udemy.java.secao17;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Aula217FileWriterBufferedWriter {

	public static void main(String[] args) {
		
		String[] linhas = new String[] {"GO-LANG","JAVA","DELPHI","C#","PHYTON","C++","PHP","TESTE"};
		
		try (  BufferedWriter gravadorDeBuffer = new BufferedWriter( new FileWriter("c:\\temp\\java.txt") ) ) {
			
			for ( String linha : linhas ) {
				gravadorDeBuffer.write(linha);
				gravadorDeBuffer.newLine();
			}
			
		}
		catch(IOException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("Programa finalizado");

	}

}
