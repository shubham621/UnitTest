package com.tcs.employee.example.exception;

import org.springframework.http.HttpStatus;

public class TCSException extends Exception {

	private HttpStatus statusCode;
	private String message;
	
	
	public TCSException(HttpStatus statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
		this.message = message;
	}


	public HttpStatus getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
}
