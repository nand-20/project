package com.cg.oeca.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
@Component
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class AppointmentIdNotFoundException extends RuntimeException{
	public AppointmentIdNotFoundException() {
		super();
	}
	public AppointmentIdNotFoundException(String message) {
		super(message);
	}
}