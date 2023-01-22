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
		LocalDateTime d02 = LocalDateTime.parse("2023-01-22T18:33:01");
		Instant d03 = Instant.parse("2023-01-22T18:33:01Z");
		
		DateTimeFormatter fmtDataPadrao = DateTimeFormatter.ISO_DATE;
		DateTimeFormatter fmtDataHora = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter fmtDataComTimeZone = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.systemDefault());
		
		System.out.println("D01 => " + fmtDataPadrao.format(d01));
		System.out.println("D02 => " + fmtDataHora.format(d02));
		System.out.println("D03 => " + fmtDataComTimeZone.format(d03));

	}

}
