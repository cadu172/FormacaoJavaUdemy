package br.com.udemy.java.secao19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import br.com.udemy.java.secao19.model.entities.LogAcesso;

public class Aula246ExercicioSet {

	public static void main(String[] args) {		
		
		Locale.setDefault(Locale.US);
		
		try ( BufferedReader fileBufferReader = new BufferedReader(new FileReader("c:\\temp\\logsite.csv")) ) {
			
			Set<LogAcesso> logList = new HashSet<LogAcesso>();
			
			String line = fileBufferReader.readLine();
			
			while ( line != null ) {
				
				String[] fields = line.split(" ");
				
				logList.add(new LogAcesso(fields[0], Instant.parse(fields[1])));
				
				// get next line
				line = fileBufferReader.readLine();
				
			}
			
			for (LogAcesso logAcesso : logList) {
				System.out.println(logAcesso);
			}
			
			System.out.println();
			System.out.println();
			System.out.println("Resume Login");
			System.out.println("User quantity login: " + logList.size());
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
