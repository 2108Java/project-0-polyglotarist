package com.revature.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	
	
	public Customer() {
		
	}


	public Customer(String firstname, String lastname, String email, String phone) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}
	
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/postgres";
	String username = "postgres" ;
	String password = "";
	
	
	public String viewBalance(String username, String password) {
		
		
		return "";
	}
	 
	
	public List<Customer> applyForAccount() {
		
		List<Customer> customerList = new ArrayList<>();
		
		//Establish connection
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM Customers";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println(rs);
			
			
			
			int i = 0;
			while(rs.next()) {
				//looping through all the rows until no rows
				
				customerList.add(
						new Customer(
							rs.getString("firstname"),
							rs.getString("lastname"),
							rs.getString("Email"),
							rs.getString("phone")
						)
				);
				i++;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i< 8; i++) {
			System.out.println(customerList.get(i));
		}
		return customerList;
		
	}
	
	public  void withdraw() {
		
	}
	
	public void deposit() {
		
	}
	
	public void makeTransfer() {
		
	}
	
	public void acceptTransfer() {
		
	}

}
