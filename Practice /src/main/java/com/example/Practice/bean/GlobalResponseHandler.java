package com.example.Practice.bean;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalResponseHandler {

	public static ResponseEntity<Object> createResponse(String message, Object data, HttpStatus status) {
		HashMap<String, Object> response = new HashMap<>();
		response.put("message", message);
		response.put("Data", data);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	public static ResponseEntity<Object> createResponse(String message, HttpStatus status) {
		HashMap<String, Object> response = new HashMap<>();
		response.put("message", message);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
