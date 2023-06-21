package model.dao;

import db.DB;
import model.dao.interfaces.InterfaceDepartmentDAO;
import model.dao.interfaces.InterfaceSellerDAO;

public class DAOFactory {
	
	public static InterfaceSellerDAO createSellerDAO() {
		return new SellerDAOJDBC(DB.getConnection());
	}

	public static InterfaceDepartmentDAO createDepartmentDAO() {
		return new DepartmentDAOJDBC(DB.getConnection());
	}
	
}
