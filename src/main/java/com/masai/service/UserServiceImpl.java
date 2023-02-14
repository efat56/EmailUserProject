package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.UserException;
import com.masai.model.User;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public User createUser(User user) {
		return userDao.save(user);
	}

	@Override
	public List<User> getAllUser() throws UserException {
		
		List<User> user = userDao.findAll();
		
		if(user.size()==0) {
			throw new UserException("There are no users");
		}else {
			return user;
		}
	}

	

	@Override
	public User getUserById(Integer id) throws UserException {
		Optional<User> optUser = userDao.findById(id);
		
		if(optUser.isPresent()) {
			return optUser.get();
		}else {
			throw new UserException("No user with id... : "+id);
		}
	}

	@Override
	public String deleteUser(Integer id) throws UserException {
		Optional<User> optUser = userDao.findById(id);
		
		if(optUser.isPresent()) {
			return "User Deleted...!";
		}else {
			throw new UserException("No user with id.... : "+id);
		}
	}

}
