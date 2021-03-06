package com.maryan.zenchef.errors.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
	
	private HttpStatus httpStatus;
	
	public ApiException(String message, HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
