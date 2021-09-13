package com.revature.models;

import java.util.List;

public interface TransactionService {
	
	public List<Transaction> getAllTransactions();
	
	public List<Transaction> getAllCompleteTransactions();
	public List<Transaction> getAllIncompleteTransactions();
	
	public boolean deleteTransaction(int id);
}
