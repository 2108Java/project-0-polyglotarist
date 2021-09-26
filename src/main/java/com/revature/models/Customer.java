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
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	
	
	static int currentCustomerObjectId;
	static int currentUserObjectId;
	
	
	Customer customer;
	Employee employee = new Employee();
	Scanner sc = new Scanner(System.in);
	ConnectionFactory connectionFactory = new ConnectionFactory();
	String sql;
//	String sql2;
	PreparedStatement ps;
	User user = new User();
	AccountClass account = new AccountClass();
	int currentBalance = 0;
	
	boolean trigger = false;// signals acceptTransfer() method that there is a transfer pending.
	
	public Customer(int customer_id, String firstname, String lastname, String email, String phone) {
//		super();
		this.customer_id = customer_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		
	}
	
	
	public int getCustomerId() {
		return customer_id;
	}
	
	public void setCustomerId(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstrname() {
		return firstname;
	}

	public void setFirstrname(String firstrname) {
		this.firstname = firstrname;
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
		// TODO Auto-generated constructor stub
	}


	@Override
	public void applyForAccount() {
		
		System.out.println("Enter firstname: ");
		String firstname = sc.nextLine();

		System.out.println("Enter last name");
		String lastname = sc.nextLine();

		System.out.println("Enter email: ");
		String email = sc.nextLine();

		System.out.println("Enter phone number");
		String phone = sc.nextLine();
		
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
				System.out.println("Congratulations! Your applicatin is approved. "
						+ "You will be prompted to make an initial deposit when "
						+ "registering your account.");
				currentCustomerObjectId = customer.getCustomerId();
//				System.out.println("the current object customer_id is: "+ customer.getCustomerId());

			}else{
				System.out.println("Sorry, your application is denied.");
			}
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void register() {

		System.out.println("Please choose a username");
		String usernameInput = sc.nextLine();
		
		System.out.println("Please type a password: ");
		String passwordInput = sc.nextLine();
		
		//save info into users table:
		sql = "INSERT INTO users(username, password) VALUES(?,?)";
		
		try{
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, usernameInput);
			ps.setString(2, passwordInput);
			
			
			ps.execute();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		sql = "SELECT * FROM users WHERE username = ?";
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, usernameInput);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user = new User(
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("password")
				);			
			}
			
			if(usernameInput.equals(user.getUsername())) {
				System.out.println("You are added as an authorized user to the system.");
				currentUserObjectId = user.getUserId();
//				System.out.println("the current object customer_id is: "+ customer.getCustomerId());

		
		System.out.println("You have successfully registered your account. ");
		makeInitialDeposit();
			}else {
				System.out.println("You have not been successfully added as an authorized user. Please try again.");
			}
		
		}catch(SQLException e) {
				e.printStackTrace();
		}
		
	}

	@Override
	public boolean login() {
		
		boolean success = false;
		
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
				user = new User(
						rs.getInt("user_id"), 
						rs.getString("username"), 
						rs.getString("password")
				);
			}
			
//			System.out.println("got here");
			if(userInput.equals(user.getUsername()) && userInput2.equals(user.getPassword())) {
				System.out.println("You have successfully logged in.");
				success = true;
			}else {
				System.out.println("You have entered the wrong credentials! Please try again: ");
			}	

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//System.out.println("the userId is: "+ user.getUserId());
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
		
		System.out.println("Your current balance is: " + currentBalance );
	}

	@Override
	public boolean withdraw() {
		
		System.out.println("Enter amount to withdraw: ");
		int withdrawAmount = sc.nextInt();
		
		if(withdrawAmount < 0) {
			System.out.println("transaction rejected. Entry cannot be negative.");
			return false;
		}
		
		currentBalance -= withdrawAmount;
		
		//update the database with new balance:
		
		sql = "UPDATE accounts SET balance = ? WHERE fk_customer_id = ?";
		
		try {
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, currentBalance);
			ps.setInt(2, currentCustomerObjectId);
			ps.execute();
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(withdrawAmount +" dollars have been withdrawn from your account. "
				+ "your remaining balance is: "+ currentBalance);
		return true;
		
		
	}
	
	//helper method to make the first deposit when applying:
	
	public void makeInitialDeposit() {
		
		System.out.println("please enter insert amount you would like to deposit into the machine: ");
		int userDepositAmount = sc.nextInt();
		currentBalance += userDepositAmount;
		if (userDepositAmount < 0) {
			System.out.println("The bills inserted were rejected!");
			
		}

		sql = "INSERT INTO accounts(balance, fk_user_id, fk_customer_id) VALUES(?,?,?)";

		try {
			Connection connection = connectionFactory.getConnection();

			ps = connection.prepareStatement(sql);
			ps.setInt(1, userDepositAmount);
			ps.setInt(2, user.getUserId());
			ps.setInt(3, customer.getCustomerId());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(userDepositAmount + " dollars have been added to your account.");
		
		sql = "SELECT * FROM accounts WHERE fk_customer_id = ? ";
		
		try{
			Connection connection = connectionFactory.getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, currentCustomerObjectId);
			
			
		    ResultSet rs = ps.executeQuery();
		    
		    
			while(rs.next()) {
				account = new AccountClass(
						rs.getInt("balance"), 
						rs.getInt("fk_user_id"), 
						rs.getInt("fk_customer_id")
				);
			}	

		}catch(SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public boolean deposit() {
		
		//we prompt user to make a deposit to add to old balance.
		boolean success = false;
		
		System.out.println("please enter insert amount you would like to deposit into the machine: ");
		int userDepositAmount = sc.nextInt();
		
		if(userDepositAmount < 0) {
			System.out.println("The bills inserted were rejected!");
			return false;
		}
		
		currentBalance += userDepositAmount;
		
		sql = "UPDATE accounts SET balance = ? WHERE fk_customer_id = ?";
		
		try {
			Connection connection = connectionFactory.getConnection();
			
			ps = connection.prepareStatement(sql);
			ps.setInt(1, currentBalance);
//			ps.setInt(2, user.getUserId());
			ps.setInt(2, currentCustomerObjectId);
			ps.execute();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(userDepositAmount + " dollars have been added to your account.");
		
		return success;
		
		
	}
	
	

	@Override
	public boolean transfer() {
		
		trigger = true;
		boolean success = false;
		
		if(acceptTransfer()) {
			System.out.println("Please enter receiver's email: ");
			String receiverEmail = sc.nextLine();
			System.out.println("Please enter the amount you would like to transfer: ");
			int transferAmount = sc.nextInt();
			
			//withdraw from sender:
			sql = "UPDATE accounts SET balance = ? WHERE fk_customer_id = ?";
			
			try {
				Connection connection = connectionFactory.getConnection();
				ps = connection.prepareStatement(sql);
				ps.setInt(1, transferAmount);
				ps.setInt(2,  currentCustomerObjectId);
				ps.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			//deposit to receiver
			sql = "UPDATE accounts SET balance = ? WHERE email = ?";
			try {
				Connection connection = connectionFactory.getConnection();
				ps = connection.prepareStatement(sql);
				ps.setInt(1, transferAmount);
				ps.setString(2,  receiverEmail);
				
				ps.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return success;
		
	}

	@Override
	public boolean acceptTransfer() {
		boolean success = false;
		if(trigger) {
			success = true;
		}	
		return success;
	}

	public List<Customer> selectAtivitiesByUserId(int id) {
		
		String sql = "SELECT * FROM customers_table WHERE fk_user_id = ?";
		List<Customer> customerTransactions = new ArrayList<>();

		return null;
	}

}
