package com.revature;

import com.revature.dao.CustomerTransactions;
import com.revature.dao.CustomerTransactionsImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.presentation.PresentationImpl;
import com.revature.service.Authenticator;
import com.revature.service.AuthenticatorImpl;

public class MainDriver {
	
	public static void main(String[] args) {
		
		
		PresentationImpl menu = new PresentationImpl();
		menu.welcomeMessage();
		menu.display();
		
		UserDao uDao = new UserDaoImpl();
		CustomerTransactions customerTransactions = new CustomerTransactionsImpl();
		
		Authenticator auth = new AuthenticatorImpl(uDao, customerTransactions);
		
		
		
	}

}
