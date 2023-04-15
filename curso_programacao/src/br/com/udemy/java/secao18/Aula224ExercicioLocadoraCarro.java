package br.com.udemy.java.secao18;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao18.model.entities.CarRental;
import br.com.udemy.java.secao18.model.entities.Vehicle;
import br.com.udemy.java.secao18.model.services.BrazilTaxService;
import br.com.udemy.java.secao18.model.services.RentalService;

public class Aula224ExercicioLocadoraCarro {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entre com os dados do aluguel");
		
		System.out.print("Modelo do Carro: ");
		String carModel = scan.nextLine();
				
		System.out.print("Data de Locacao (DD/MM/YYYY HH:MM:): ");
		String dataAuxiliar = scan.nextLine();
		LocalDateTime start = LocalDateTime.parse(dataAuxiliar,DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

		System.out.print("Data de Entrega do Veiculo (DD/MM/YYYY HH:MM:): ");
		dataAuxiliar = scan.nextLine();
		LocalDateTime finish = LocalDateTime.parse(dataAuxiliar,DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		System.out.print("Preco da Locacao por Hora:  ");
		float pricePerHour = scan.nextFloat();

		System.out.print("Preco da Locacao por Dia:  ");
		float pricePerDay = scan.nextFloat();
		
		
		try {
		
			CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
			RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService() );
			
			rentalService.processInvoice(carRental);
			
			System.out.println("");
			System.out.println("");
			System.out.println("VALOR DA FATURA: ");
			System.out.println("Modelo do Carro: " + carRental.getVehicle().getModel());
			System.out.println("Base de Calculo: $ " + String.format("%.2f",carRental.getInvoice().getBasicPayment()));
			System.out.println("ICMS: $ " + String.format("%.4f",  carRental.getInvoice().getTax()));
			System.out.println("Valor da Locacao: $ " + String.format("%.2f",   carRental.getInvoice().getTotalPayment()));		

		}
		catch ( Exception e ) {
			
			e.printStackTrace();
			
		}
		
		scan.close();
		
	}

}
