package com.cg.oeca.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Component;
@Component
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class TestIdNotFoundException extends RuntimeException{
	public TestIdNotFoundException() {
		super();
	}
	public TestIdNotFoundException(String message) {
		super(message);
	}
}
