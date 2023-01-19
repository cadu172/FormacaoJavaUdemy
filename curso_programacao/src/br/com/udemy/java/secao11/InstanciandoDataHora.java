package br.com.udemy.java.secao11;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InstanciandoDataHora {

	public static void main(String[] args) {
		
		Instant d01 = Instant.now();
		LocalDate d02 = LocalDate.now();
		LocalDateTime d03 = LocalDateTime.now();
		
		LocalDate d04 = LocalDate.parse("1981-09-17");
		LocalDateTime d05 = LocalDateTime.parse("1981-09-17T09:51:05");
		
		Instant d06 = Instant.parse("2023-01-19T00:07:55Z");
		Instant d07 = Instant.parse("2023-01-19T00:07:55-03:00"); //em relação ao horário de londres
		
		LocalDate d08 = LocalDate.parse("17/09/1981",DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		LocalDateTime d09 = LocalDateTime.parse("17/09/1981 09:55",DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		LocalDate d10 = LocalDate.of(1981, 9, 17);
		
		LocalDateTime d11 = LocalDateTime.of(1981,9,17,9,55);
		
		
		System.out.println("(UTC/GMT) Londes - d01 => " + d01.toString());
		System.out.println("(Data atual no Brasil) - d02 => " + d02.toString());
		System.out.println("(UTC-3) Sao Paulo - d03 => " + d03.toString());
		System.out.println("Str para Date - d04 => " + d04.toString());
		System.out.println("Str para DateTime - d05 => " + d05.toString());
		System.out.println("Str para Instant - d06 => " + d06.toString());
		System.out.println("Str para Instant - d07 => " + d07.toString());
		System.out.println("Str para Date (formatado) - d08 => " + d08.toString());
		System.out.println("Str para DateTime (formatado) - d09 => " + d09.toString());
		System.out.println("usando o método statico of - d10 => " + d10.toString());
		System.out.println("usando o método statico of - d11 => " + d11.toString());

	}

}
