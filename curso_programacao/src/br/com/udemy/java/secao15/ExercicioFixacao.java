package br.com.udemy.java.secao15;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao15.model.entities.Conta;

public class ExercicioFixacao {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner scan = new Scanner(System.in);		
		
		try {		
		
			System.out.print("Informe o nome do titular da conta: ");
			String nomeTitular = scan.nextLine();
			
			System.out.print("Informe o Numero da Conta: ");
			Integer numeroDaConta = scan.nextInt();
			
			System.out.print("Informe o Saldo inicial da Conta: ");
			Double saldo = scan.nextDouble();
			
			System.out.print("Informe o Limite Maximo de Saque: ");
			Double limiteDeSaque = scan.nextDouble();
			
			Conta contaCorrente = new Conta(numeroDaConta, nomeTitular, saldo, limiteDeSaque);
			
			System.out.print("Qual o valor do Saque? ");
			Double valorDoSaque = scan.nextDouble();
			
			contaCorrente.efetuarSaque(valorDoSaque);
			
			System.out.println();
			System.out.println("Saldo Apos Operacao de Saque: " + String.format("%.2f", contaCorrente.getSaldo()));		
			
		
		}
		catch ( Exception e ) {
			
			System.out.println("Erro de Saque: " + e.getMessage());
			
		}
		finally {
			
			scan.close();
			
		}

	}

}
