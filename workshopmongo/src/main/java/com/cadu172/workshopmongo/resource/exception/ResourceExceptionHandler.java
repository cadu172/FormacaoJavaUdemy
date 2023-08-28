package com.cadu172.workshopmongo.resource.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cadu172.workshopmongo.service.exception.GenericServiceException;
import com.cadu172.workshopmongo.service.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(GenericServiceException.class)
	public ResponseEntity<StandardResourceError> genericException(GenericServiceException e, HttpServletRequest request) {
		String error = "Services.Exceptions.GenericException";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardResourceError err = new StandardResourceError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}	

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardResourceError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardResourceError err = new StandardResourceError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
