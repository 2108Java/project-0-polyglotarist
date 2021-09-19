package com.revature.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.util.ConnectionFactory;

public class Customer implements CustomerInterface{
	
//	private int id;
	private String firstrname;
	private String lastname;
	private String email;
	private String phone;
	
	
	Employee employee = new Employee();

	public String getFirstrname() {
		return firstrname;
	}

	public void setFirstrname(String firstrname) {
		this.firstrname = firstrname;
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

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Customer(int id, String username) {
//		super();
//		this.id = id;
//		this.username = username;
//	}
	
	
	

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}

	@Override
	public void applyForAccount() {
		// TODO Auto-generated method stub
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter firstname: ");
		String firstname = sc.nextLine();

		System.out.println("Enter last name");
		String lastname = sc.nextLine();

		System.out.println("Enter email: ");
		String email = sc.nextLine();

		System.out.println("Enter phone number");
		String phone = sc.nextLine();
		
		
		//
		
		//persist info to database:
		PreparedStatement ps;
		
		String sql = "INSERT INTO "
				+ "customers(firstname, lastname, email, phone)"
				+ " VALUES(?,?,?,?)";
		
		try{
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setString(1,firstname);
			ps.setString(2,lastname);
			ps.setString(3, email);
			ps.setString(4, phone);
			
			ps.execute();
			
			

		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		System.out.println("Please wait while we process your information...");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		employee.processApplication();
		
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean withdraw(double amount) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deposit(double amount) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean transfer(double amount) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptTransfer() {
		// TODO Auto-generated method stub
		
	}

	public List<Customer> selectAtivitiesByUserId(int id) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM customers_table WHERE fk_user_id = ?";
		List<Customer> customerTransactions = new ArrayList<>();
//		try {
//			
//			ConnectionFactory connection;
//				connection = ConnectionFactory.getConnection();
//			
//			}
//			PreparedStatement ps = connection.prepareStatement(sql);
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		
		return null;
	}
	

}
