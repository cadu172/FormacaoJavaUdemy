package application;

import java.sql.Connection;

import db.DB;

public class program {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();		
		System.out.println("teste");		
		DB.closeConnection();

	}

}
