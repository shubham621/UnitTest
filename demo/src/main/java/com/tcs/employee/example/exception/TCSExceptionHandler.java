package com.tcs.employee.example.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TCSExceptionHandler {
	
	
	@ExceptionHandler(value = TCSException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(TCSException exception){
		
		ErrorResponse responseMessage = new ErrorResponse(exception.getMessage(), exception.getStatusCode().name());
		
		ResponseEntity<ErrorResponse> resp = new ResponseEntity<ErrorResponse>(responseMessage, exception.getStatusCode());
		
		return resp;
		
	}

}
