package com.revature.dao;

import java.util.List;

import com.revature.models.Customer;

public interface CustomerTransactions {
	
	List<Customer> selectActivitiesByUserId(int id);

}
