package br.com.udemy.java.secao17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Aula215FileReaderBufferedReader {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileReader leitorDeArquivo = null;
		BufferedReader leitorDeBuffer = null;
		
		try {
		
			leitorDeArquivo = new FileReader("c:\\temp\\DISAL_10072020_REPASSE_0000003_2020.TXT");
			leitorDeBuffer = new BufferedReader(leitorDeArquivo);
			
			String linhaAtual = leitorDeBuffer.readLine();
			
			while ( linhaAtual != null ) {
				System.out.println(linhaAtual);
				linhaAtual = leitorDeBuffer.readLine();
			}
		
		}
		catch ( IOException e ) {
			
			System.out.println(e.getMessage());
			
		}
		finally {
			
			try {
			
				if ( leitorDeArquivo != null ) {
					
					leitorDeArquivo.close();
					
				}
				
				if ( leitorDeBuffer != null ) {
					
					leitorDeBuffer.close();
					
				}  
			
			}
			catch ( Exception e ) {
				
				e.printStackTrace();
			}			
			
		}

	}

}
