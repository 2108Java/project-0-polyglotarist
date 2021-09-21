package com.revature.presentation;

import com.revature.service.Authenticator;
import com.revature.service.AuthenticatorImpl;

import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.User;

public class PresentationImpl implements PresentationInterface{
	
	Customer customer = new Customer();
	
	private Authenticator auth;
	
	public PresentationImpl(Authenticator auth) {
		this.auth = auth;
	}
	
	public PresentationImpl() {
		// TODO Auto-generated constructor stub
		
		
	}


	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Bank App! Please select "
				+ "an activity from the menu: ");
		System.out.println("1) Apply for a new account");
		System.out.println("2) Register");
		System.out.println("3) Log in");
		
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		
		switch(userInput) {
		case "1":
			customer.applyForAccount();
			break;
		case "2":
			customer.register();
			break;
		case "3":
			customer.login();
			break;
		case "4": 
			break;
		default:
			break;
					
		}
		
//		customer.register();
//		customer.logout();
//		customer.viewBalance();
//		customer.deposit(100);
//		customer.withdraw(50);
//		
		
	}
	
	

}
