package com.exospher3.restapitest.service;

import com.exospher3.restapitest.entity.User;

public interface UserService {

	
	public User getUserById(Integer id);

	public User saveUser(User user);
}
