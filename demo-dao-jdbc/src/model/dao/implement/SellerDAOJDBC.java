package model.dao.implement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
		
		PreparedStatement cmd = null;
		ResultSet qyrSeller = null;
		
		try {		
		
			cmd = conn.prepareStatement(" select s.*, d.Name as DepName  from seller s "
					+ " inner join department d on ( d.Id  = s.DepartmentId ) "
					+ " where s.id = ?; ");
			cmd.setInt(1, id);
			
			qyrSeller = cmd.executeQuery();
			
			if ( qyrSeller.next() ) {
				Department department = instantiateDepartment(qyrSeller);
				Seller seller = instantiateSeller(qyrSeller, department);				
				return seller;
			}
		
			return null;
			
		}
		catch ( SQLException e ) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(qyrSeller);
			DB.closeStatement(cmd);
		}		
		
	}

	private Seller instantiateSeller(ResultSet qyrSeller, Department department) throws SQLException {
		
		Seller seller = new Seller();

		seller.setId(qyrSeller.getInt("Id"));
		seller.setName(qyrSeller.getString("Name"));
		seller.setEmail(qyrSeller.getString("Email"));
		seller.setBirthDate(qyrSeller.getDate("BirthDate"));
		seller.setBaseSalary(qyrSeller.getDouble("BaseSalary"));
		seller.setDepartment(department);
		
		return seller;
		
	}

	private Department instantiateDepartment(ResultSet qyrSeller) throws SQLException {
		
		Department department = new Department();
		department.setId(qyrSeller.getInt("DepartmentId"));				
		department.setName(qyrSeller.getString("DepName"));
		
		return department;
		
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		
		ResultSet qyrSeller = null;
		PreparedStatement cmd = null;
		
		try {		
			
			cmd = conn.prepareStatement(" SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name ");
			cmd.setInt(1, department.getId());
			
			qyrSeller = cmd.executeQuery();
			
			List<Seller> sellerList = new ArrayList<>();
			
			HashMap<Integer, Department> hashDepartment = new HashMap<>();
			
			while ( qyrSeller.next() ) {
				
				Department dep = hashDepartment.get(qyrSeller.getInt("DepartmentId"));
				
				if ( dep  == null ) {					
					dep = instantiateDepartment(qyrSeller);					
					hashDepartment.put(qyrSeller.getInt("DepartmentId"),dep);
				}
				
				sellerList.add(instantiateSeller(qyrSeller, dep));
			
			}
		
			return sellerList;
			
		}
		catch ( SQLException e ) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(qyrSeller);
			DB.closeStatement(cmd);
		}
		
		
	}

	
	
}
