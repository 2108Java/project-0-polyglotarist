package com.revature.dao;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDaoImpl implements UserDao {
	
	ConnectionFactory connectionFactory = new ConnectionFactory();

	@Override
	public User selectUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
