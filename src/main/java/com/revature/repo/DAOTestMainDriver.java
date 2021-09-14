package com.revature.repo;

import java.util.Scanner;

import com.revature.models.Customer;

public class DAOTestMainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hi");
		
		Customer database = new Customer();
		
//		Customer[] result = new Customer[10];
		
		database.applyForAccount();
		
		
		System.out.println("Welcome to EBank");
		System.out.println("Please select an option from the menu: ");
		
		Menu m = new Menu();
		m.prettyDisplay();
		
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		System.out.println("You selected option: "+userInput);
		
		database.register();
		
		

	}

}
