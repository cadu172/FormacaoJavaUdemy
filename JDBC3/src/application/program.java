package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;

import db.DB;

public class program {

	public static void main(String[] args) {
		
		/*Connection conn = DB.getConnection();		
		System.out.println("teste");		
		DB.closeConnection();*/
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			
			conn = DB.getConnection();
			
			/*st = conn.prepareStatement("INSERT INTO coursejdbc.seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES(?,?,?,?,?);", PreparedStatement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "CARLOS EDUARDO");
			st.setString(2, "cadu172@gmail.com");
			st.setDate(3, new java.sql.Date(new SimpleDateFormat("yy/MM/yyyy").parse("17/09/1981").getTime()));
			st.setDouble(4, 4500.00);
			st.setInt(5, 1);*/
			
			st = conn.prepareStatement(" insert into coursejdbc.department (Name) values ('TI'),('FINANCEIRO'),('COBRANCA'),('RH'); ",
					Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = st.executeUpdate();			
			
			System.out.println("Success! Rows Affected = " + rowsAffected);
			
			if (  rowsAffected > 0 ) {
				
				ResultSet rs = st.getGeneratedKeys();
				
				while ( rs.next() ) {
					
					Integer id = rs.getInt(1);
					
					System.out.println("Id de vendedor gerado = " + id);
					
				}
				
			}
			
		}
		catch ( SQLException e  ) {
			e.printStackTrace();
		}
		/*catch ( ParseException e ) {
			e.printStackTrace();
		}*/
		finally {
			
			/*DB.closeResultSet(rs);
			DB.closeStatement(st);*/
			DB.closeConnection(conn);
		}
		
		
		

	}

}
