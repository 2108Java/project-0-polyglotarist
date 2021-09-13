package com.revature.models;

public interface UserDao {
	
	public User selectUseByUsername(String username);
	public boolean insertUser(User u);
	
}
