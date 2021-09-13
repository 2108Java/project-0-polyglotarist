package com.revature.models;

import java.util.List;

public interface BankService {
	
	public List<Transaction> getAllTransactions();
	
	public List<Transaction> getAllCompleteTransactions();
	
	public List<Transaction> getAllIncompleteTransactions();

}
