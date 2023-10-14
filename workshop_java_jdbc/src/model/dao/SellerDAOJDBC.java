package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.interfaces.InterfaceSellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDAOJDBC implements InterfaceSellerDAO {
	
	private Connection conn = null;
	
	public SellerDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		
		PreparedStatement st = null;
		
		try {
			
			st = this.conn.prepareStatement (
					 " insert into coursejdbc.seller (name, email, birthdate, basesalary, departmentid) "
					+" values(?,?,?,?,?);",PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1,obj.getName());
			st.setString(2,obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			
			int rowsAffected = st.executeUpdate();
			
			if ( rowsAffected > 0  ) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				if (  rs.next() ) {
					
					obj.setId(rs.getInt(1));
					
				}
				
				DB.closeResultSet(rs);
				
			}
			else {
				throw new DbException("Erro ao tentar incluir vendedor, nenhum registro incluido apos comando de Insert");
			}
			
		}
		catch ( SQLException e ) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Seller obj) {

		PreparedStatement st = null;
		
		try {
			
			st = this.conn.prepareStatement (
					   " update coursejdbc.seller "
					 + " set name=?, email=?, birthdate=?, basesalary=?, departmentid=? "
					 + " where id=?; ");
			
			st.setString(1,obj.getName());
			st.setString(2,obj.getEmail());
			st.setDate(3, new java.sql.Date(obj.getBirthDate().getTime()));
			st.setDouble(4, obj.getBaseSalary());
			st.setInt(5, obj.getDepartment().getId());
			st.setInt(6, obj.getId());			
			st.executeUpdate();
			
		}
		catch ( SQLException e ) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}		
		
	}

	@Override
	public void deleteById(Integer id) {
		
		PreparedStatement st = null;
		
		try {
			
			st = this.conn.prepareStatement("delete from coursejdbc.seller where id = ?;");
			st.setInt(1, id);
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}		
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
		seller.setBirthDate(new Date(qyrSeller.getTimestamp("BirthDate").getTime()));
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
		ResultSet qyrSeller = null;
		PreparedStatement cmd = null;
		
		try {		
			
			cmd = conn.prepareStatement(" SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name ");			
			
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
