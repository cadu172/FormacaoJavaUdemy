package br.com.udemy.java.secoes_01_02_03_04_05;

import java.util.Scanner;

public class UsandoSwitchCase {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		byte diaSemana = scan.nextByte();
		String textoDiaSemana = "";
		
		switch(diaSemana) {
			case 1:
				textoDiaSemana = "Hoje eh Domingo";
				break;
			case 2:
				textoDiaSemana = "Hoje eh segunda-feira";
				break;
			case 3:
				textoDiaSemana = "Hoje eh terca-feira";
				break;
			case 4:
				textoDiaSemana = "Hoje eh quarta-feira";
				break;
			case 5:
				textoDiaSemana = "Hoje eh quinta-feira";
				break;
			case 6:
				textoDiaSemana = "Sextou!";
				break;
			case 7:
				textoDiaSemana = "Hoje eh Sabadaum";
				break;
			default:
			textoDiaSemana = "Dia da semana invalido";
		}
		
		System.out.println(textoDiaSemana);
		
		scan.close();

	}

}
