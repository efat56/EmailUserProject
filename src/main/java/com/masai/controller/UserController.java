package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmailException;
import com.masai.exception.UserException;
import com.masai.model.Email;
import com.masai.model.User;
import com.masai.service.EmailService;
import com.masai.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUserHandler() throws UserException{
		List<User> list = userService.getAllUser();
		return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUserHandler(@RequestBody User user){
		User u = userService.createUser(user);
		return new ResponseEntity<User>(u,HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable Integer id) throws UserException{
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUserByIdHandler(@PathVariable Integer id) throws UserException{
		String str = userService.deleteUser(id);
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}/mail/{mail_Id}")
	public ResponseEntity<Email> getEmailByUserHandler(@PathVariable Integer id,@PathVariable Integer mail_Id) throws UserException, EmailException{
		Email email = emailService.getEmail(id, mail_Id);
		return new ResponseEntity<Email>(email,HttpStatus.OK);
	}
	
	@PostMapping("/user/{id}/mail")
	public ResponseEntity<Email> createEmailByUserHandler(@PathVariable Integer id,@RequestBody Email email) throws UserException{
		Email mail = emailService.createMail(id, email);
		return new ResponseEntity<Email>(mail,HttpStatus.CREATED);
	}
	
	
}
