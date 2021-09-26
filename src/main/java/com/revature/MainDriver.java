package com.revature;

import org.apache.log4j.Logger;

import com.revature.dao.CustomerTransactions;
import com.revature.dao.CustomerTransactionsImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.presentation.PresentationImpl;
import com.revature.service.Authenticator;
import com.revature.service.AuthenticatorImpl;



public class MainDriver {
	
	private final static Logger loggy = Logger.getLogger(MainDriver.class);
	
	public static void main(String[] args) {
		
		loggy.info("application started.");
		
		PresentationImpl menu = new PresentationImpl();
		menu.welcomeMessage();
		menu.display();
		
		UserDao uDao = new UserDaoImpl();
		CustomerTransactions customerTransactions = new CustomerTransactionsImpl();
		
		Authenticator auth = new AuthenticatorImpl(uDao, customerTransactions);
		
		
		
	}

}
