package com.revature.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
	
	
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	
	
	public Customer() {
		
	}


	public Customer(String firstname, String lastname, String email, String phone) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setEmail(email);
		this.setPhone(phone);
	}
	
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/postgres";
	String username = "postgres" ;
	String password = "";
	
	
	public String viewBalance(String username, String password) {
		
		
		return "";
	}
	 
	
	public String invokeScanner() {
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		return userInput;
	}
	
	public void register() {
		System.out.println("Please enter your first name: ");
		
		this.setFirstname(invokeScanner()); 
		System.out.println("you entered: "+ this.getFirstname());
		
		System.out.println("Please enter your last name: ");

		this.setLastname(invokeScanner()); 
		System.out.println("you entered: "+ this.getLastname());
		
		System.out.println("Please enter your email: ");

		this.setEmail(invokeScanner()); 
		System.out.println("you entered: "+ this.getEmail());


		System.out.println("Please enter your phone number: ");

		this.setPhone(invokeScanner()); 
		System.out.println("you entered: "+ this.getPhone());
		
		

	}
	
	
	
	public List<Customer> applyForAccount() {
		
		List<Customer> customerList = new ArrayList<>();
		
		//Establish connection
		try(Connection connection = DriverManager.getConnection(url, username, password)){
			String sql = "SELECT * FROM Customers";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
		//	System.out.println(rs);
			
			
			
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
		
//		for(int i = 0; i< 8; i++) {
//			System.out.println(customerList.get(i));
//		}
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


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

}
