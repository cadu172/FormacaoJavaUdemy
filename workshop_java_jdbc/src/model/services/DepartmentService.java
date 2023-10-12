package model.services;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.DepartmentDAOJDBC;
import model.entities.Department;

public class DepartmentService {
	
	private DepartmentDAOJDBC departmentDAO = (DepartmentDAOJDBC) DAOFactory.createDepartmentDAO();
	
	public List<Department> findAll() {
		return departmentDAO.findAll();		
	}
	
	public void saveOrUpdate(Department department) {
		if ( department == null ) {
			throw new IllegalStateException("department was null on DepartmentService.saveOrUpdate");
		}
		
		if ( department.getId() == null ) {
			departmentDAO.insert(department);
		}
		else {
			departmentDAO.update(department);
		}
	}
	
	public void remove(Department department) {
		
		if ( department == null ) {
			throw new IllegalStateException("DepartmentService.remove -> department was null");
		}
		
		departmentDAO.deleteById(department.getId());
				
	} 

}
