package com.example.Practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practice.bean.ResponseBean;
import com.example.Practice.entity.Users;
import com.example.Practice.service.UsersService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UsersController {

	@Autowired
	private UsersService userService;

	@PostMapping("/saveuser")
	public ResponseEntity<ResponseBean> saveUserDetails(@RequestBody Users user) {

		return new ResponseEntity<>(userService.saveUserDetails(user), HttpStatus.CREATED);
	}

	@GetMapping("/fetchuser/{id}")
	public ResponseEntity<ResponseBean> fetchUserDetails(@PathVariable Long id) {

		return new ResponseEntity<>(userService.fetchUserDetails(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/fetchuserall")
	public ResponseEntity<ResponseBean> fetchAllDetails() {

		return new ResponseEntity<>(userService.fetchAllDetails(), HttpStatus.OK);
	}

}
