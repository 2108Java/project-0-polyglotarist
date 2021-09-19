package com.revature.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class Employee implements EmployeeInterface{

	@Override
	public void processApplication() {
		// TODO Auto-generated method stub
		boolean userExists = false;
		Customer customer = new Customer();
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		PreparedStatement ps;
		String sql = "SELECT * FROM customers WHERE email = ?";

		
		try{
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, customer.getEmail());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Congratulations! Your application is approved.");
				
			}else {
				System.out.println("Sorry, your application is denied.");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void viewAccount(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewTransactionsLog() {
		// TODO Auto-generated method stub
		
	}

}
