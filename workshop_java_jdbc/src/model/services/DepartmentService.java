package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Department;

public class DepartmentService {
	
	public List<Department> findAll() {
		
		List<Department> list = new ArrayList<>();
		
		list.add(new Department(1,"Roupas"));
		list.add(new Department(2,"Eletrônicos"));
		list.add(new Department(3,"Brinquedos"));
		list.add(new Department(4,"Farmacia"));
		
		return list;
		
	}

}
