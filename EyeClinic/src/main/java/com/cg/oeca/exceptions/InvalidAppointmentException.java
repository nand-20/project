package com.cg.oeca.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Component;
@Component
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InvalidAppointmentException extends RuntimeException{
	public InvalidAppointmentException() {
		super();
	}
	public InvalidAppointmentException(String message) {
		super(message);
	}
}