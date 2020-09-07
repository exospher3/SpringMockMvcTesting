package com.exospher3.restapitest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exospher3.restapitest.entity.User;
import com.exospher3.restapitest.repository.UserRepository;

@Service
public class UserServiceImpli implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	}


	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	
}
