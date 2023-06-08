package com.cg.oeca.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Component;
@Component
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class PatientIdFoundNotException extends RuntimeException {
	public PatientIdFoundNotException() {
		super();
	}
	public PatientIdFoundNotException(String message) {
		super(message);
	}
}
