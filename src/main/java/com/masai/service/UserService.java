package com.masai.service;

import java.util.List;

import com.masai.exception.UserException;
import com.masai.model.User;

public interface UserService {
	
	public List<User> getAllUser() throws UserException;
	
	public User createUser(User user);
	
	public User getUserById(Integer id)throws UserException;
	
	public String deleteUser(Integer id)throws UserException;
	
}
