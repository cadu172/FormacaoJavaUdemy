package model.dao;

import db.DB;
import model.dao.implement.DepartmentDAOJDBC;
import model.dao.implement.SellerDAOJDBC;

public class DAOFactory {
	
	public static InterfaceSellerDAO createSellerDAO() {
		return new SellerDAOJDBC(DB.getConnection());
	}

	public static InterfaceDepartmentDAO createDepartmentDAO() {
		return new DepartmentDAOJDBC();
	}
	
}
