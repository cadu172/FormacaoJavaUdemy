package br.com.udemy.java.secao11;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConversaoDataGlobalParaLocal {

	public static void main(String[] args) {
		
		/**
		 * Seção 11|112 - convertendo data-hora global para Local 
		 */
		LocalDate dataSimples = LocalDate.parse("1981-09-17");
		LocalDateTime dataHora = LocalDateTime.parse("1981-09-17T09:50:01");
		Instant dataHoraGMT = Instant.parse("1981-09-17T09:50:01Z");
		
		/*
		 // esta rotina imprime todos os timezone disponiveis na linguagem JAVA
		 for ( String timeZone : ZoneId.getAvailableZoneIds() ) {
			System.out.println(timeZone);
		}*/
		
		// encontrar a data de Brasilia com relação a uma data GMT/UTC Londres
		LocalDate dataEmBrasilia = LocalDate.ofInstant(dataHoraGMT, ZoneId.systemDefault());
		LocalDateTime dataHoraEmBrasilia = LocalDateTime.ofInstant(dataHoraGMT, ZoneId.systemDefault());
		LocalDateTime dataHoraNaAustralia = LocalDateTime.ofInstant(dataHoraGMT, ZoneId.of("Australia/Lindeman"));
		
		System.out.println("Data Padrao em Brasilia: " + dataEmBrasilia.toString());
		System.out.println("Data e Hora em Brasilia: " + dataHoraEmBrasilia.toString());
		System.out.println("Data e Hora na Australia [Australia/Lindeman]: " + dataHoraNaAustralia.toString());
		
		System.out.println(" ["+dataHora.toString()+"] Dia "  + dataHora.getDayOfMonth() );
		System.out.println(" ["+dataHora.toString()+"] Mes "  + dataHora.getMonthValue() );
		System.out.println(" ["+dataHora.toString()+"] Ano "  + dataHora.getYear() );
		
		System.out.println(" ["+dataHora.toString()+"] Hora "  + dataHora.getHour() );
		System.out.println(" ["+dataHora.toString()+"] Minuto "  + dataHora.getMinute() );
		System.out.println(" ["+dataHora.toString()+"] Segundo "  + dataHora.getSecond() );
		
		
	}

}
