package br.com.udemy.java.secao14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.udemy.java.secao14.entities.ImportedProduct;
import br.com.udemy.java.secao14.entities.Product;
import br.com.udemy.java.secao14.entities.UsedProduct;

public class Exercicio2 {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		//----------------------------------------------------
		// array com os produtos informados pelo usuário
		ArrayList<Product> productList = new ArrayList<Product>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
		
		//-----------------------------------------------------
		System.out.print("Enter the number of products: ");
		int numberProducts = scan.nextInt();scan.nextLine();		
		
		for (int item=1; item<=numberProducts; item++) {
			
			System.out.println("Product #"+item+" data:");
			
			// recebe o tipo de produto
			System.out.print("Common, used or imported (c/u/i)? ");
			char productType = scan.next().charAt(0);scan.nextLine();			
			
			System.out.print("Name: ");
			String name = scan.nextLine();
			
			System.out.print("Price: ");
			float price = scan.nextFloat();scan.nextLine();
			
			if ( productType == 'i'  ) {
				
				System.out.print("Customs fee: ");
				float customsFee = scan.nextFloat();
				productList.add( new ImportedProduct(name, price, customsFee) );
			
			}
			else if ( productType == 'c' ) {				
			
				productList.add( new Product(name, price) );			
			
			}
			else if ( productType == 'u' ) {
				
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				
				String dataTexto = scan.nextLine();
				
				Date manufactureDate = sdf.parse(dataTexto);

				productList.add( new UsedProduct(name, price, manufactureDate) );
			
			}
			
		}
		
		//----------------------------------------------------
		scan.close();
		
		System.out.println("\n\nPRICE TAGS: ");
		
		for (Product product : productList) {			
			System.out.println(product.priceTag());
		}
		
	}

}
