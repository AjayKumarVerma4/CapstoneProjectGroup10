package com.hcl.capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entity.User;
import com.hcl.capstone.exception.UserException;
import com.hcl.capstone.repository.UserRepository;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	// register new user
	@Override
	public User addUser(User user) throws UserException {
		if(!searchByEmail(user.getEmail()))
		   return userRepository.saveAndFlush(user);
		else
			throw new UserException("email id already exist");
	}

	private boolean searchByEmail(String email) {
		boolean b=false;
		User user=userRepository.findByEmail(email);
		if(user != null) {
			b=true;
		}
		return b;
	}

	// login user
	@Override
	public User getUserByEmailAndPassword(String email, String password) throws UserException {
		User user=null;
		if(searchByEmail(email)) 
		   user=userRepository.getUserByEmailAndPassword(email, password);
		else
			throw new UserException("email id does not exist");
		
		return user;
	}

	@Override
	public User getUserById(long id) throws UserException {
		if (userRepository.findById(id).isPresent())
			return userRepository.findById(id).get();
		else
			throw new UserException("id does not exist");
	}

}
