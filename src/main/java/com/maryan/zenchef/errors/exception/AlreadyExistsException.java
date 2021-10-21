package com.maryan.zenchef.errors.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends ApiException {

	public AlreadyExistsException(String message) {
		super(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
