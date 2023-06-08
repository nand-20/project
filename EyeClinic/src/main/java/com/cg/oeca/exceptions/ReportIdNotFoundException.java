package com.cg.oeca.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Component;
@Component
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ReportIdNotFoundException extends RuntimeException{
	public ReportIdNotFoundException() {
		super();
	}
	public ReportIdNotFoundException(String message) {
		super(message);
	}
}
