package com.revature.models;

import java.util.List;

public class User {
	


	private String username;
	private String password;
	
	public User() {
		super();
	}
	
	public User(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	
	





	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Customer> getTransactionsList() {
		return transactionsList;
	}


	public void setTransactionsList(List<Customer> transactionsList) {
		this.transactionsList = transactionsList;
	}


	private String name;
	private List<Customer> transactionsList;

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", transactionsList="
				+ transactionsList + "]";
	}
	

	
	
}
