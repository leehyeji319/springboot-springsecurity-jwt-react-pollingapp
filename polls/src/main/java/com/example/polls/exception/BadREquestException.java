package com.example.polls.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadREquestException extends RuntimeException {

	public BadREquestException(String message) {
		super(message);
	}

	public BadREquestException(String message, Throwable casue) {
		super(message, casue);
	}
}
