package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class program {

	public static void main(String[] args) {
		
		Connection conn = null;		
		PreparedStatement st = null;
		
		
		try {
			
			conn = DB.getConnection();
			
			st = conn.prepareStatement (
					" UPDATE coursejdbc.seller "
					+ " SET BaseSalary = BaseSalary + ? "
					+ " WHERE DepartmentId = ?;");
			
			st.setDouble(1,200.00);
			st.setInt(2, 2);
			
			
			int rowsAffected = st.executeUpdate();
			
			
			System.out.println("Success!  Rows Affected " + rowsAffected);
			
			
		}
		catch ( SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			DB.closeConnection(conn);
			
		}
		

	}

}
