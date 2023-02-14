package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {

		@ExceptionHandler(EmailException.class)
		public ResponseEntity<MyErrorDetails> email_Handler(EmailException e, WebRequest req) {
				
			MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),req.getDescription(false));	
			return new ResponseEntity<>(myErr, HttpStatus.BAD_REQUEST);
		}
		
	
	
		@ExceptionHandler(UserException.class)
		public ResponseEntity<MyErrorDetails> UserHandler(UserException e, WebRequest req) {
			
            MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), e.getMessage(),req.getDescription(false));
			return new ResponseEntity<>(myErr, HttpStatus.BAD_REQUEST);
		}
		

	
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	   public ResponseEntity<MyErrorDetails> methodHandler(MethodArgumentNotValidException ie,WebRequest req) {
			
			MyErrorDetails myErr=new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
			return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
			
	    }
	   
	   
	   @ExceptionHandler(NoHandlerFoundException.class)
	   public ResponseEntity<MyErrorDetails> wrongApi_Handler(NoHandlerFoundException e, WebRequest req){
		
		  MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
		  return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	   }
	   

		@ExceptionHandler(Exception.class)
		public ResponseEntity<MyErrorDetails> logical_Handler(Exception e, WebRequest req){
			
			MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), e.getMessage(), req.getDescription(false));
			return new ResponseEntity<>(myErr,HttpStatus.BAD_REQUEST);
				
	    }
	   	
	
}
