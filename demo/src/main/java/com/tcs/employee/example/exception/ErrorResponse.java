package com.tcs.employee.example.exception;

public class ErrorResponse {
	
	private String errorMessage;
	private String httpStatusCode;
	
	
	public ErrorResponse(String errorMessage, String httpStatusCode) {
		super();
		this.errorMessage = errorMessage;
		this.httpStatusCode = httpStatusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getHttpStatusCode() {
		return httpStatusCode;
	}
	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	
	

}
