package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerTransactions {
	
	
	public void insertCustomerRow();
	
	public void selectCustomerByEmail();
	
	public void insertUser();
	
	public void selectUserByUsername();
	
	public void insertAccount();
	
	public void selectAccountByCustomerId();
	
	public void updateAccountBalance();
	
	
	
	
	
	List<Customer> selectActivitiesByUserId(int id);

}
