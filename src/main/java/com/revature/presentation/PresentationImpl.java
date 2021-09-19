package com.revature.presentation;

import com.revature.service.Authenticator;
import com.revature.service.AuthenticatorImpl;
import com.revature.models.User;

public class PresentationImpl implements PresentationInterface{
	
	private Authenticator auth;
	
	public PresentationImpl(Authenticator auth) {
		this.auth = auth;
	}
	
	public PresentationImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("Welcome to Bank App! Please select "
				+ "an activity from the menu: ");
		System.out.println("1) Apply for a new account");
		System.out.println("2) Register");
		System.out.println("3) Log in");
		
	}

	public void welcomeMessage() {
		System.out.println("Welcome to the Bank App");
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	

}
