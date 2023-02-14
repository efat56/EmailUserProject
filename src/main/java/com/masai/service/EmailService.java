package com.masai.service;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;

public interface EmailService {
	
	public Email getEmail(Integer userId,Integer email_Id)throws UserException,EmailException;
	
	public Email createMail(Integer userId,Email mail)throws UserException;

}
