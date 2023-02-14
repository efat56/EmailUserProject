package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;
import com.masai.repository.EmailDao;
import com.masai.repository.UserDao;

@Service
public class EmailServiceImpl implements EmailService{
	
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EmailDao emailDao;

	@Override
	public Email getEmail(Integer userId, Integer email_Id) throws UserException, EmailException {
		
		Optional<User> optUser = userDao.findById(userId);
		
		if(optUser.isPresent()) {
			Email email = optUser.get().getEmail();
			if(email==null) {
				throw new EmailException("No Email found with id...: "+email_Id);
			}else {
				return email;
			}
		}else {
			throw new UserException("No User found... : "+userId);
		}
	}

	@Override
	public Email createMail(Integer userId, Email mail) throws UserException {
		Optional<User> optUser = userDao.findById(userId);
		if(optUser.isPresent()) {
			optUser.get().setEmail(mail);
			emailDao.save(mail);
			userDao.save(optUser.get());
			return mail;
		}else {
			throw new UserException("No User founf...: "+userId);
		}
	}

	
}
