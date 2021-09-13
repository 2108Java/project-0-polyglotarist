package com.revature.models;

public interface AuthenticationService {
	
	
	//Verifies that the user exists
	public boolean validate(String username);
	
	// verifies that the password matches
	public boolean authenticate(String username, String password);

}
