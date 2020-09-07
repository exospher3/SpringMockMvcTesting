package com.exospher3.restapitest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exospher3.restapitest.entity.User;
import com.exospher3.restapitest.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id){
		return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
		
	}

}
