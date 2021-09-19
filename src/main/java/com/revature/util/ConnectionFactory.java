package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String URL = "jdbc:postgresql://localhost/";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "";
	
	public Connection getConnection() throws SQLException{
		
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return connection;
	}

}
