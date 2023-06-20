package application;

import java.util.Date;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.interfaces.InterfaceSellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class program {

	public static void main(String[] args) {
		
		/*Department department = new Department(1, "Tecnologia da Informação");		
		//System.out.println(department);
		
		Seller seller = new Seller (
				1, //Integer id, 
				"Carlos Eduardo dos Santos Roberto", //String name, 
				"cadu172@gmail.com", //String email, 
				Date.from(Instant.parse("1981-09-17T00:00:00Z")), //Date birthDate, 
				5600.00, //Double baseSalary
				department
				);
		
		System.out.println(seller);*/
				
		
		System.out.println("#### sellerDAO::findById ####");
		
		InterfaceSellerDAO sellerDAO = DAOFactory.createSellerDAO();
		
		Seller seller = sellerDAO.findById(3);
		
		if ( seller != null ) {
			System.out.println(seller);
		}
		else {
			System.out.println("Seller ID not found!");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("#### sellerDAO::findByDepartment ####");
		List<Seller> sellerList = sellerDAO.findByDepartment(new Department(2, ""));
		
		for ( Seller item : sellerList ) {
			System.out.println(item);
		}
		

		System.out.println();
		System.out.println("#### sellerDAO::insert ####");
		Seller newSeller = new Seller();
		newSeller.setName("Carlos Eduardo");
		newSeller.setEmail("cadu172@gmail.com");
		newSeller.setBirthDate(new Date());
		newSeller.setBaseSalary(7500.22);
		newSeller.setDepartment(new Department(1, ""));
		
		// inclusao do novo funcionario
		sellerDAO.insert(newSeller);
		
		System.out.println("Success, Id of new Seller: " + newSeller.getId());		
		
		System.out.println();		
		System.out.println("#### sellerDAO::findAll ####");
		sellerList = sellerDAO.findAll();
		
		for ( Seller item : sellerList ) {
			System.out.println(item);
		}
		
		
	

	}

}
