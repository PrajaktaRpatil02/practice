package com.example.Practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Practice.bean.GlobalResponseHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { EntityNotFound.class })
	public ResponseEntity<Object> handleDataNotFound(EntityNotFound notFound) {

		return GlobalResponseHandler.createResponse(notFound.getMessage(), HttpStatus.NOT_FOUND);
		
	}
}
