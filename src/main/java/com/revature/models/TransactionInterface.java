package com.revature.models;

import java.util.List;

public interface TransactionInterface {
	
	//select
	public List<Transaction> selectAll();
	public List<Transaction> selectAllComplete();
	public List<Transaction> selectAllIncomplete();
	
	
	public List<Transaction> select(String title);
	public Transaction select(int id);
	
	
	//Update:
	
	public boolean setComplete(int id);
	public boolean setIncomplete(int id);
	public boolean approveApplication(int id);
	
	
	//Delete:
	public boolean deleteTransaction(int id);
	
	//insert:
	
	public boolean createTransaction(Transaction transaction);

}
