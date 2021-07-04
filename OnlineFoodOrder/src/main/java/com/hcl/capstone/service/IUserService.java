package com.hcl.capstone.service;

import com.hcl.capstone.entity.User;
import com.hcl.capstone.exception.UserException;

public interface IUserService {

	public User addUser(User user) throws UserException;

	public User getUserByEmailAndPassword(String email, String password) throws UserException;

	public User getUserById(long id) throws UserException;

}
