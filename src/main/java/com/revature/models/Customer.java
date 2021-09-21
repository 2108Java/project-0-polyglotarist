package com.revature.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.util.ConnectionFactory;

public class Customer implements CustomerInterface{
	
	private int customer_id;
	private String firstrname;
	private String lastname;
	private String email;
	private String phone;
	
	
	Employee employee = new Employee();
	Scanner sc = new Scanner(System.in);
	ConnectionFactory connectionFactory = new ConnectionFactory();
	String sql;
	PreparedStatement ps;
	
	

	public Customer(int customer_id, String firstrname, String lastname, String email, String phone) {
		super();
		this.customer_id = customer_id;
		this.firstrname = firstrname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		
	}
	
	public int getCustomerId() {
		return customer_id;
	}

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
		
		Customer customer = new Customer();
		
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
		
		sql = "INSERT INTO "
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
			
		System.out.println("Please wait while an employee processes your information...");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
//		employee.processApplication(email);
		
		sql = "SELECT * FROM customers WHERE email = ?";
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customer = new Customer(
						rs.getInt("customer_id"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("email"),
						rs.getString("phone")
				);			
			}
			
			if(email.equals(customer.getEmail())) {
				System.out.println("Congratulations! Your applicatin is approved.");
			}else{
				System.out.println("Sorry, your application is denied.");
			}
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
//		if(employeeApproval) {
//			System.out.println("Congratulations! Your application is approved.");
//		}else {
//			System.out.println("Sorry, your application is denied.");
//		}
		
	}

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
		User user = new User();

		System.out.println("Please choose a username");
		user.setUsername(sc.nextLine());
		System.out.println("Please type a password: ");
		user.setPassword(sc.nextLine());
		
		
//		System.out.println(user.getUsername());
		
		//save info into users table:
		sql = "INSERT INTO users(username, password) VALUES(?,?)";
		
		try{
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			
			
			ps.execute();
			
			

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		boolean success = false;
		User user = new User();
		System.out.println("Please enter your username");
		
		String userInput = sc.nextLine();
		
		System.out.println("Please enter your password");
		
		String userInput2 = sc.nextLine();

		
		sql = "SELECT * FROM users WHERE username = ? ";
		
		try{
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, userInput);
			
			
		    ResultSet rs = ps.executeQuery();
		    
		    
			while(rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"));
			}
			
//			System.out.println("got here");
			if(userInput.equals(user.getUsername()) && userInput2.equals(user.getPassword())) {
				System.out.println("You have successfully logged in.");
				success = true;
			}else {
				System.out.println("You have entered the wrong credentials! Please try again: ");
			}	
			
			connection.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		System.out.println("Thank you for using the Bank App!");
		System.exit(0);
	
	}

	@Override
	public void viewBalance() {
		// TODO Auto-generated method stub
//		sql = "SELECT * FROM accounts_table WHERE isChecking = true";
		
	}

	@Override
	public boolean withdraw() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deposit() {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean transfer() {
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

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	

}
