package com.revature.models;

import java.util.List;

public class User {
	

	private int id;
	private String username;
	private String password;
	
	public User() {
		super();
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
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", transactionsList=" + transactionsList + "]";
	}
	
}
