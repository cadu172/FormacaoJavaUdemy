package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.interfaces.InterfaceDepartmentDAO;
import model.entities.Department;

public class DepartmentDAOJDBC implements InterfaceDepartmentDAO {
	
	private Connection conn;
	
	public DepartmentDAOJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = this.conn.prepareStatement("insert into coursejdbc.department (name) values(?);",
						PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			
			int rowsAffected = st.executeUpdate();
			
			if ( rowsAffected < 1 ) {
				throw new DbException("Unknown Error on insert coursejdbc.department");
			}
			else {
				
				rs = st.getGeneratedKeys();
				
				if ( rs.next() ) {
					obj.setId(rs.getInt(1));
				}
				
			}
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void update(Department obj) {
		
		
		PreparedStatement st = null;
		
		try {
			
			st = this.conn.prepareStatement(" update coursejdbc.department set name = ? where id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
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
			
			st = this.conn.prepareStatement("delete from coursejdbc.department where id = ?");
			st.setInt(1, id);
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Department findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select id, name from coursejdbc.department where id = ?");
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if (  rs.next() ) {				
				
				return new Department(rs.getInt("id"), rs.getString("name"));
				
			}
			
		}
		catch(SQLException e) {
			
			throw new DbException(e.getMessage());
			
		}
		finally {
			
			DB.closeResultSet(rs);
			DB.closeStatement(st);			
			
		}
		
		// return null default
		return null;
	}

	@Override
	public List<Department> findAll() {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement("select id, name from coursejdbc.department order by id");
			rs = st.executeQuery();
			
			List<Department> departmentList = new ArrayList<>();
			
			while (  rs.next() ) {
				
				departmentList.add(new Department(rs.getInt("id"), rs.getString("name")));
				
			}
			
			return departmentList;
			
		}
		catch(SQLException e) {
			
			throw new DbException(e.getMessage());
			
		}
		finally {
			
			DB.closeResultSet(rs);
			DB.closeStatement(st);			
			
		}

	
	}
	
	
}
