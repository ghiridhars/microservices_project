package com.mindtree.Consumer.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ConsumerMicroserviceException.class)
	public ResponseEntity<String> handleFetchException(ConsumerMicroserviceException fe, WebRequest wr,Model m) {
		ErrorDetails ed = new ErrorDetails(fe.getMessage(), new Date(), wr.getDescription(false));
		System.out.println(ed);
		return new ResponseEntity<String>(ed.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
}
