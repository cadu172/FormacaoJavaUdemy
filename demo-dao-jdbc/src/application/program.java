package application;

import java.time.Instant;
import java.util.Date;

import model.entities.Seller;
import model.dao.DAOFactory;
import model.dao.InterfaceSellerDAO;
import model.entities.Department;

public class program {

	public static void main(String[] args) {
		
		Department department = new Department(1, "Tecnologia da Informação");		
		//System.out.println(department);
		
		Seller seller = new Seller (
				1, //Integer id, 
				"Carlos Eduardo dos Santos Roberto", //String name, 
				"cadu172@gmail.com", //String email, 
				Date.from(Instant.parse("1981-09-17T00:00:00Z")), //Date birthDate, 
				5600.00, //Double baseSalary
				department
				);
		
		System.out.println(seller);
				
		
		InterfaceSellerDAO sellerDAO = DAOFactory.createSellerDAO();
		

	}

}
