package br.com.udemy.java.secao11;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculosComDataHora {

	public static void main(String[] args) {
		/*
		 * Seção 11|113 - Calculos com data-hora
		 * 
		 * Neste capitulo o instrutor ensina como realizar operações de soma, subtração, diferença entre data e hora etc		 
		 *
		 */
		
		LocalDate dataPadrao = LocalDate.parse("2023-01-24");
		LocalDateTime dataHora = LocalDateTime.parse("2023-01-24T23:41:00");
		Instant dataHoraUTC = Instant.parse("2023-01-24T23:41:00Z");		
		
		//datas cadastradas para teste
		System.out.println("dataPadrao => " + dataPadrao.toString());
		System.out.println("dataHora => " + dataHora.toString());
		System.out.println("dataHoraUTC => " + dataHoraUTC.toString());
		System.out.println("-----------------------------------------------");
		
		System.out.println("dataPadrao +2 dias => " + dataPadrao.plusDays(2).toString());
		System.out.println("dataHora -45 minutos => " + dataHora.plusMinutes(45).toString());
		System.out.println("dataHoraUTC -20 minutos => " + dataHoraUTC.minus(20, ChronoUnit.MINUTES));
		System.out.println("dataHoraUTC +20 minutos => " + dataHoraUTC.plus(20, ChronoUnit.MINUTES));
		System.out.println("dataHoraUTC +3 SEMANAS => " + dataHoraUTC.plus(7*3, ChronoUnit.DAYS));
		System.out.println("-----------------------------------------------");
		
		Instant semanaPassada = dataHoraUTC.minus(7, ChronoUnit.DAYS);
		Instant proximaSemana = dataHoraUTC.plus(7, ChronoUnit.DAYS);
		
		
		System.out.println("semanaPassada => " + semanaPassada);
		System.out.println("proximaSemana => " + proximaSemana);
		
		Duration duracaoSemana = Duration.between(semanaPassada, proximaSemana);
		
		System.out.println("Diferenca entre as duas semanas => " + duracaoSemana.toDays());
		
		System.out.println("-----------------------------------------------");
		
		LocalDate dataSemanaPassada = dataPadrao.minusDays(7);
		LocalDate dataProximaSemana = dataPadrao.plusDays(7);
		
		Duration diferencaDataPadrao = Duration.between(dataSemanaPassada.atStartOfDay(), dataProximaSemana.atStartOfDay());
		
		System.out.println("Diferenca entre as duas semanas data padrao => " + diferencaDataPadrao.toDays());
		
		
		
		
		
		
		

	}

}
