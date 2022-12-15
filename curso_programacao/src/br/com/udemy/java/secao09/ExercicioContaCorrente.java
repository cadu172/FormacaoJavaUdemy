package br.com.udemy.java.secao09;

import java.util.Locale;
import java.util.Scanner;
import br.com.udemy.java.secao09.entities.Account;

public class ExercicioContaCorrente {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);		
		
		Scanner scan = new Scanner(System.in);
		
		// objeto conta (sem construção inicial
		Account conta;
		
		double value = 0;
		
		System.out.print("Enter Account Number:");
		int accountNumber = scan.nextInt();
		
		scan.nextLine();
		
		System.out.print("Enter Account holder: ");
		String name = scan.nextLine();
		
		System.out.print("Is there initial deposit valid (Y/N)?");
		char option = scan.nextLine().charAt(0);
	
		if ( option == 'Y' ) {			
			System.out.print("Initial deposit value: ");
			value = scan.nextDouble();
			conta = new Account(accountNumber, name, value);			
		}
		else {
			conta = new Account(accountNumber, name);
		}
		
		
		System.out.print("Account data: \n" + conta.toString());		
		
		
		System.out.print("\nEnter a deposit value: ");
		value = scan.nextDouble();
		conta.makeDeposit(value);
		System.out.print("Updated account data:\n" + conta.toString());		
		

		System.out.print("\nEnter a withdraw value: ");
		value = scan.nextDouble();
		conta.withDraw(value);
		System.out.print("Updated account data:\n" + conta.toString());	
		
		
		scan.close();			
		

	}

}
