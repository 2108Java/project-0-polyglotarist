package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String url = "jdbc:postgresql://localhost";
	private static final String username = "postgres";
	private static final String password = "";
	
	public Connection getConnection() throws SQLException{
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}

}
