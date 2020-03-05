package com.endava.school4it;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {


	@ExceptionHandler({ RuntimeException.class })
	public ResponseEntity<Object> handleException(RuntimeException exception) {
		return new ResponseEntity<>("Something went wrong"
				, HttpStatus.BAD_REQUEST);
	}

}
