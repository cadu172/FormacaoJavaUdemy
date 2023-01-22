package br.com.udemy.java.secao11;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ConvertendoDataEmTexto {

	public static void main(String[] args) {
		
		/*
		 * SEÇÃO 11
		 * AULA 111. Convertendo data-hora para texto
		 */
		
		LocalDate d01 = LocalDate.parse("2023-01-22");
		LocalDateTime d02 = LocalDateTime.parse("2023-01-22T01:33:01");
		Instant d03 = Instant.parse("2023-01-22T01:33:01Z"); 
		/* a letra Z no final da string da data indica que é uma data de Londres
		 a data de londres é equivalente a data "UTC" ou "GMT" que é o padrão usado como referencia
		 */
		
		DateTimeFormatter fmtDataPadrao = DateTimeFormatter.ISO_DATE; //ENUM com uma constante de um formato de data padrão
		DateTimeFormatter fmtDataHora = DateTimeFormatter.ISO_DATE_TIME; //Enum com o formato de data de hora sem timezone
		
		
		DateTimeFormatter fmtDataComTimeZone = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.systemDefault());
		/* formato de data de hora com timezone do computador, como estamos com o fusuhorário de São Paulo estamos a 3 horas a menos
		 menos que o GMT, logo a data sairá com 3 horas amenos na tela
		 */
		
		
		System.out.println("D01 => " + fmtDataPadrao.format(d01));
		System.out.println("D02 => " + fmtDataHora.format(d02));
		System.out.println("D03 => " + fmtDataComTimeZone.format(d03));

	}

}
