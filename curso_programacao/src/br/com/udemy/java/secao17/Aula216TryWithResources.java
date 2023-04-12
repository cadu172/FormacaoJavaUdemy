package br.com.udemy.java.secao17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aula216TryWithResources {

	public static void main(String[] args) {
		
		
		try ( BufferedReader leitorDeBuffer = new BufferedReader(new FileReader("c:\\temp\\DISAL_10072020_REPASSE_0000003_2020.TXT")) ) {
		
			String linhaAtual = leitorDeBuffer.readLine();
			
			while ( linhaAtual != null ) {
				System.out.println(linhaAtual);
				linhaAtual = leitorDeBuffer.readLine();
			}
		
		}
		catch ( IOException e ) {
			
			System.out.println(e.getMessage());
			
		}
		catch ( Exception e ) {
			
			e.printStackTrace();
		
		}

	}

}
