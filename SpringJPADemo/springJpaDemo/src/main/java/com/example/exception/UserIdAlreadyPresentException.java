package com.example.exception;


@SuppressWarnings("serial")
public class UserIdAlreadyPresentException extends Exception{
	
	public UserIdAlreadyPresentException(String message) {
		super(message);
	}

}
