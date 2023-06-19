package model.dao.implement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.InterfaceSellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDAOJDBC implements InterfaceSellerDAO {
	
	private Connection conn = null;
	
	public SellerDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		try {		
		
			PreparedStatement cmd = conn.prepareStatement(" select s.*, d.Name as nameDep  from seller s "
					+ " inner join department d on ( d.Id  = s.DepartmentId ) "
					+ " where s.id = ?; ");
			cmd.setInt(1, id);
			
			ResultSet qyrSeller = cmd.executeQuery();
			
			if ( qyrSeller.next() ) {
				
				//Department department = new Department( qyrSeller.getInt("DepartmentId"), qyrSeller.getString("nameDep") );				
				
				Department department = new Department();				
				department.setId(qyrSeller.getInt("DepartmentId"));				
				department.setName(qyrSeller.getString("nameDep"));
				
				Seller seller = new Seller();				
				seller.setId(qyrSeller.getInt("Id"));
				seller.setName(qyrSeller.getString("Name"));
				seller.setEmail(qyrSeller.getString("Email"));
				seller.setBirthDate(qyrSeller.getDate("BirthDate"));
				seller.setBaseSalary(qyrSeller.getDouble("BaseSalary"));
				seller.setDepartment(department);
				
				return seller;
				
			}
		
			return null;
			
		}
		catch ( SQLException e ) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
