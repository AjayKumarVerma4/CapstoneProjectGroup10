package com.hcl.capstone.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.capstone.entity.User;
import com.hcl.capstone.exception.MenuException;
import com.hcl.capstone.exception.UserException;
import com.hcl.capstone.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService iUserService;

	@PostMapping("/addUser")
	public ResponseEntity<User> addNewUser(@RequestBody User user) throws UserException{
		User usr = iUserService.addUser(user);
			return new ResponseEntity<User>(usr, HttpStatus.OK);
	}
	
	@PostMapping("/getUser")
	public ResponseEntity<User> getUser(@RequestBody User user) throws UserException{
		String email=user.getEmail();
		String password=user.getPassword();
		log.info(email+"==="+password);
		User usr = iUserService.getUserByEmailAndPassword(email, password);
		return new ResponseEntity<User>(usr,HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable("id") long id) throws MenuException, UserException {
		User user = iUserService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
