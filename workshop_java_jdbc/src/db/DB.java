package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	public static Connection conn = null;
	
	public static Connection getConnection() {
		
		if ( conn == null ) {
			
			try {
				
				Properties props = loadProperties();				
				
				conn = DriverManager.getConnection(props.getProperty("dburl"),props);
				
			}
			catch ( SQLException e ) {
				
				throw new DbException(e.getMessage());
				
			}
			
		}		
		
		return conn;
		
	}
	
		
	public static Properties loadProperties() {
		
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			
			Properties props = new Properties();
			
			props.load(fs);
			
			return props;
			
		}
		catch ( IOException e ) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	
	public static void closeConnection(Connection conn) {
		
		if ( conn != null ) {
			
			try {
				conn.close();
			}
			catch(SQLException e ) {
				throw new DbException(e.getMessage());
			}			
			
		}
		
	}
	
	public static void closeStatement(Statement st) {
		try {
			if (  st != null ) {
				st.close();
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		try {
			if ( rs != null ) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	

}
