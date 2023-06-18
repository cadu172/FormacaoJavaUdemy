package model.dao;

import model.dao.implement.DepartmentDAOJDBC;
import model.dao.implement.SellerDAOJDBC;

public class DAOFactory {
	
	public static InterfaceSellerDAO createSellerDAO() {
		return new SellerDAOJDBC();
	}

	public static InterfaceDepartmentDAO createDepartmentDAO() {
		return new DepartmentDAOJDBC();
	}
	
}
