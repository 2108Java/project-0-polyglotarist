package com.revature.models;

public interface CustomerInterface {
	
	
	
	public void applyForAccount();
	
	public void register();
	
	public boolean login();
	
	public boolean logout();
	
	public void viewBalance();
	
	public boolean withdraw(double amount);
	
	public boolean deposit(double amount);
	
	public boolean transfer(double amount);
	
	public void acceptTransfer();
	
	
}
