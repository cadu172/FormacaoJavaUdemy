package br.com.udemy.java.secao06;

import java.util.Locale;
import java.util.Scanner;

public class EstruturaRepetitivaDoWhile {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner scan = new Scanner(System.in);
		
		float temperaturaC = 0.0f;
		float temperaturaF = 0.0f;
		char respostaQuestao = 'S';
		
		do {
			
			System.out.print("Digite a temperatura em celsius: ");
			temperaturaC = scan.nextFloat();
			
			// calcular a temperatura em Fahrenheit
			temperaturaF = (float)(9.0 * temperaturaC / 5.0 + 32.0);
			
			// imprimir na consola o resultado
			System.out.printf("O valor da temperatura %.1f convetida eh %.1f %n",temperaturaC,temperaturaF);
			
			// pergunta se o usuario quer continuar
			System.out.print("Deseja fazer um novo calculo? ");
			respostaQuestao = scan.next().charAt(0);
			
			
		} while ( respostaQuestao == 'S' ||  respostaQuestao == 's');
		
		scan.close();
		
		
	}

}
