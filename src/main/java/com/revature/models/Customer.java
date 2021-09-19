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
	
	private int id;
	private String username;
	private String lastname;
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void applyForAccount() {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter firstname: ");
		String firstname = sc.nextLine();

		System.out.println("Enter last name");
		String lasttname = sc.nextLine();

		System.out.println("Enter email: ");
		String email = sc.nextLine();

		System.out.println("Enter phone number");
		String phone = sc.nextLine();
		
		
		//
		
		//persist info to database:
		PreparedStatement ps;
		
		String sql = "INERT INTO "
				+ "customers(firstname, lastname, email, phone)"
				+ " VALUES(firstname, lastname, email, phone)";
		
		try{
			ConnectionFactory connection = new ConnectionFactory();
			ps = connection.prepareStatement(sql);

		}catch(SQLException e) {
			e.printStackTrace();
		}
			

		
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
