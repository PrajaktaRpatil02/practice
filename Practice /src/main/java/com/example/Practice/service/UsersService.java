package com.example.Practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Practice.bean.ResponseBean;
import com.example.Practice.entity.Users;
import com.example.Practice.exception.EntityNotFound;
import com.example.Practice.repository.UserRepository;

@Service
public class UsersService {

	@Autowired
	private UserRepository userRepository;

	public ResponseBean saveUserDetails(Users users) {

		ResponseBean response = new ResponseBean();

		if (ObjectUtils.isEmpty(users)) {

			throw new EntityNotFound("User details not Found");

		}
		Users save = userRepository.save(users);
		response.setData(save);
		response.setMessage("User details save successfully");

		return response;

	}

	public ResponseBean fetchUserDetails(Long id) {
		ResponseBean response = new ResponseBean();
		Users users = userRepository.findById(id).get();

		response.setData(users);
		response.setMessage("User details fetch successfully");
		return response;

	}

	public ResponseBean fetchAllDetails() {
		ResponseBean response = new ResponseBean();
		List<Users> users = userRepository.findAll();
		response.setData(users);
		response.setMessage("User details fetch successfully");
		return response;
	
	
	}

}
