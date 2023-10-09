package model.services;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.DepartmentDAOJDBC;
import model.entities.Department;

public class DepartmentService {
	
	DepartmentDAOJDBC departmentDAO = (DepartmentDAOJDBC) DAOFactory.createDepartmentDAO();
	
	public List<Department> findAll() {
		
		/*List<Department> list = new ArrayList<>();
		
		list.add(new Department(1,"Roupas"));
		list.add(new Department(2,"Eletrônicos"));
		list.add(new Department(3,"Brinquedos"));
		list.add(new Department(4,"Farmacia"));
		
		return list;*/
		return departmentDAO.findAll();
		
	}

}
