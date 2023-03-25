package br.com.udemy.java.secao15;

import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao15.model.entities.Conta;

public class ExercicioFixacao {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner scan = new Scanner(System.in);		
		
		try {		
		
			System.out.println("### INFORME OS DADOS DA CONTA ###\n");
			
			System.out.print("Numero da Conta: ");
			Integer numeroDaConta = scan.nextInt();scan.nextLine();
			
			System.out.print("Nome do titular da conta: ");
			String nomeTitular = scan.nextLine();
			
			System.out.print("Saldo Inicial: ");
			Double saldo = scan.nextDouble();
			
			System.out.print("Limite Maximo de Saque: ");
			Double limiteDeSaque = scan.nextDouble();
			
			Conta contaCorrente = new Conta(numeroDaConta, nomeTitular, saldo, limiteDeSaque);
			
			System.out.print("\nQual o valor do Saque: ");
			Double valorDoSaque = scan.nextDouble();
			
			contaCorrente.efetuarSaque(valorDoSaque);
			
			System.out.println();
			System.out.println("Saldo Apos Operacao: " + String.format("%.2f", contaCorrente.getSaldo()));		
			
		
		}
		catch ( Exception e ) {
			
			System.out.println("Erro de Saque: " + e.getMessage());
			
		}
		finally {
			
			scan.close();
			
		}

	}

}
