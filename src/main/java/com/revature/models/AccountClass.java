package com.revature.models;

public class AccountClass {
	
	int balance;
	int userId;
	int customerId;
	
	public AccountClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountClass(int balance, int userId, int customerId) {
		super();
		
		this.balance = balance;
		this.userId = userId;
		this.customerId = customerId;

	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public int getCustomerId() {
		return this.customerId;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
