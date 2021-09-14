package com.revature.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Customer;

public class DAOTestMainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hi");
		
		Customer database = new Customer();
		
//		Customer[] result = new Customer[10];
		
		
		
		
		System.out.println("Welcome to EBank");
		System.out.println("Please select an option from the menu: ");
		
		Menu m = new Menu();
		m.prettyDisplay();
		
		Scanner sc = new Scanner(System.in);
		String userInput = sc.nextLine();
		System.out.println("You selected option: "+userInput);
		
		database.register();
		
		List<Customer> form = new ArrayList<>();
		form = database.applyForAccount();
		
		for(int i = 0; i < 8; i++) {
			System.out.println("row number "+ i+1);
			System.out.println(form.get(i).getFirstname());
			System.out.println(form.get(i).getLastname());
			System.out.println(form.get(i).getEmail());
			System.out.println(form.get(i).getPhone());
			System.out.println();
			System.out.println();
		}
		
		

	}

}
