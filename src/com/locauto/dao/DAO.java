package com.locauto.dao; 
import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DAO {
	protected Connection conexao = null;
	public void conectar() {		
		String url = "jdbc:mysql://127.0.0.1:3306/";
		String dbName = "locauto";
		String userName = "locauto";
		String password = "locauto123";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexao = DriverManager
					.getConnection(url + dbName, userName, password); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	
	 
}
