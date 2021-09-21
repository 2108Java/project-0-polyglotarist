package com.revature.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class Employee implements EmployeeInterface{
	
	User user = new User();

	@Override
	public boolean processApplication(String customer_email) {
		// TODO Auto-generated method stub
		boolean userExists = false;
		Customer customer = new Customer();
//		String customerEmail = customer.applyForAccount();
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		PreparedStatement ps;
		String sql = "SELECT * FROM customers WHERE email = ?";

		
		try{
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, customer_email);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				if(customer_email.equals(customer.getEmail()))
				System.out.println("Congratulations! Your application is approved.");
				userExists = true;
				
			}
//			else {
//				System.out.println("Sorry, your application is denied.");
//			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return userExists;
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
