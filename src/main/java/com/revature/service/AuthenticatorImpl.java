package com.revature.service;

import com.revature.dao.CustomerTransactions;
import com.revature.dao.UserDao;
import com.revature.models.Customer;
import com.revature.models.User;

public class AuthenticatorImpl implements Authenticator{
	
	private UserDao userDao;
	private Customer customerActivityDao;
	
	public AuthenticatorImpl(UserDao userDao, Customer customerActivityDao) {
		super();
		this.userDao = userDao;
		this.setCustomerActivityDao(customerActivityDao);
	}
	public AuthenticatorImpl(UserDao uDao, CustomerTransactions customerTransactions) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean authentcate(String username, String password) {
		
		// TODO Auto-generated method stub
		User u = getUser(username);
		boolean success = false;
		
		if(u!= null) {
			if(u.getPassword() != null && u.getPassword().equals(password)) {
				success = true;
			}
		}
		
		return success;
	}
	@Override
	public User getUser(String username) {
		
		// TODO Auto-generated method stub
		
		User u = userDao.selectUserByUsername(username);
				u.setTransactionsList(customerActivityDao.selectAtivitiesByUserId(u.getId()));
		return u;
	}
	public Customer getCustomerActivityDao() {
		return customerActivityDao;
	}
	public void setCustomerActivityDao(Customer customerActivityDao) {
		this.customerActivityDao = customerActivityDao;
	}
	

}
