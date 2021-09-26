package com.revature.presentation;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.MainDriver;
import com.revature.models.Customer;
import com.revature.models.Employee;
import org.apache.log4j.Logger;

public class PresentationImpl implements PresentationInterface{
	
	
	
	
	Customer customer = new Customer();
	Employee employee = new Employee();
	
	
	private static final Logger loggy = Logger.getLogger(PresentationImpl.class);

	
	public PresentationImpl() {
		// TODO Auto-generated constructor stub
		
		
	}

	public void welcomeMessage() {
		System.out.println("Welcome to Bank App! Please select "
				+ "an activity from the menu: ");
	}
	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("1) Apply for a new account");
		System.out.println("2) Register");
		System.out.println("3) Log in");
		System.out.println("4) make a deposit");
		System.out.println("5) view account balance");
		System.out.println("6) withdraw");
		System.out.println("7) make a transfer");
		System.out.println("8) accept a transfer");
		System.out.println("0) Logout");
		
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		
		switch(userInput) {
		case "1":
			loggy.info("User selected 1");
			customer.applyForAccount();
			break;
		case "2":
			customer.register();
			break;
		case "3":
			loggy.info("User selected 3");
			customer.login();
			break;
		case "4":
			loggy.info("User selected 4");
			customer.deposit();
			break;
		case "5":
			loggy.info("User selected 5");
			customer.viewBalance();
			break;
		case "6":
			loggy.info("User selected 6");
			customer.withdraw();
			break;
			
		case "7":
			loggy.info("User selected 7");
			customer.transfer();
			break;
		case "8":
			loggy.info("User selected 8");
			customer.acceptTransfer();
			break;
		case "0":
			loggy.info("User selected 0");
			customer.logout();

		default:
			System.out.println("That is not a valid input.");
			break;
					
		}
		
		display();
				
	}
	
	

}
