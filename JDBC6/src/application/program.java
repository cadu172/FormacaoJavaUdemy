package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

public class program {

	public static void main(String[] args) {
		
		Connection conn = null;		
		PreparedStatement st = null;
		
		
		try {
			
			conn = DB.getConnection();
			
			conn.setAutoCommit(false); // start transaction
			
			st = conn.prepareStatement (
					" update coursejdbc.seller set BaseSalary = 2500.01 where DepartmentId = ? ");
			st.setInt(1, 1);
			
			int rowsAffected = st.executeUpdate();
			
			if (  rowsAffected > 0 ) {
				
				//throw new SQLException("ERRO FALSO");
				
			}
			
			conn.commit();
			
			
			System.out.println("Success!  Rows Affected " + rowsAffected);
			
			
		}
		catch ( SQLException e) {
			
			
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
			}
			catch (SQLException e1) {
				throw new DbException("Error try Rollback: " + e1.getMessage());
			}
			
			
		}
		finally {
			
			DB.closeConnection(conn);
			
		}
		

	}

}
