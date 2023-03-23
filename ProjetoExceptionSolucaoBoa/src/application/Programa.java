package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		
			System.out.print("Room number: ");
			int numeroDoQuarto = scan.nextInt();scan.nextLine();
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date dataCheckIn = sdf.parse(scan.nextLine());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date dataCheckOut = sdf.parse(scan.nextLine());
			
			Reserva reservaInstance = new Reserva(numeroDoQuarto, dataCheckIn, dataCheckOut);		
			
			System.out.println("Reservation: " + reservaInstance);	
			
			System.out.println();
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			dataCheckIn = sdf.parse(scan.nextLine());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			dataCheckOut = sdf.parse(scan.nextLine());
			
			reservaInstance.updateDates(dataCheckIn, dataCheckOut);		
			System.out.println("Reservation: " + reservaInstance);
		
		}
		catch (ParseException e) {
			System.out.println("Invalid Date Format" );			
		}		
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage() );	
		}
		
		scan.close();
		
	}

}
