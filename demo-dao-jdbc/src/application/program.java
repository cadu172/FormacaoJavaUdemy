package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.interfaces.InterfaceSellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);				
		
		System.out.println("TESTE 1 - #### sellerDAO::findById ####");
		
		InterfaceSellerDAO sellerDAO = DAOFactory.createSellerDAO();
		
		Seller seller = sellerDAO.findById(3);
		
		if ( seller != null ) {
			System.out.println(seller);
		}
		else {
			System.out.println("Seller ID not found!");
		}
		
		System.out.println();
		System.out.println("TESTE 2 - #### sellerDAO::findByDepartment ####");
		
		List<Seller> sellerList = sellerDAO.findByDepartment(new Department(2, ""));
		
		for ( Seller item : sellerList ) {
			System.out.println(item);
		}
		

		System.out.println();
		System.out.println("TESTE 3 - #### sellerDAO::insert ####");
		
		/*seller = new Seller();
		seller.setName("Carlos Eduardo");
		seller.setEmail("cadu172@gmail.com");
		seller.setBirthDate(new Date());
		seller.setBaseSalary(7500.22);
		seller.setDepartment(new Department(1, ""));		
		
		// inclusao do novo funcionario
		sellerDAO.insert(seller);
		
		System.out.println("Success, Id of new Seller: " + seller.getId());*/		
		
		System.out.println();		
		System.out.println("TESTE 4 - #### sellerDAO::findAll ####");
		
		sellerList = sellerDAO.findAll();
		
		for ( Seller item : sellerList ) {
			System.out.println(item);
		}

		System.out.println();		
		System.out.println("TESTE 5 - #### sellerDAO::Update ####");
		
		seller = sellerDAO.findById(1); // localzar o Seller id = 1
		
		if ( seller != null ) {

			// alterar somente o nome
			seller.setName("Dos Santos Roberto");
			
			// atualizar
			sellerDAO.update(seller);		
			
			System.out.println(seller);
		}
		
		System.out.println();		
		System.out.println("TESTE 6 - #### sellerDAO::deleteById ####");
		
		System.out.print("Informe o ID para Exclusao: ");
		Integer id = scan.nextInt();scan.nextLine();
		
		seller = sellerDAO.findById(id);
		
		if ( seller == null ) {
			System.out.println("ID "+id+" NAO LOCALIZADO!");
		}
		else {
			
			// atualizar
			sellerDAO.deleteById(id);
			
			System.out.println("Registro excluido com sucesso");

		}		
		
		scan.close();
		

	}

}
