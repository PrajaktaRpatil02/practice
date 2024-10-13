package com.example.Practice.exception;

public class EntityNotFound extends RuntimeException{
	
	public EntityNotFound(String message) {
		super(message);
	}

}
