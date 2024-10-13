package com.example.Practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practice.bean.ResponseBean;
import com.example.Practice.entity.Address;
import com.example.Practice.service.AddressService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/saveaddress")
	public ResponseEntity<ResponseBean> saveAddress(@RequestBody Address address) {

		return new ResponseEntity<>(addressService.saveAddress(address), HttpStatus.CREATED);

	}

	@GetMapping("/address/{id}")
	public ResponseEntity<ResponseBean> fetchByIdAddress(@PathVariable Long id) {
		return new ResponseEntity<>(addressService.fetchByIdAddress(id), HttpStatus.OK);

	}

	@GetMapping("/fetchall")
	public ResponseEntity<ResponseBean> fetchAllAddress() {
		return new ResponseEntity<>(addressService.fetchAllAddress(), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseBean> updateAddress(@RequestBody Address address, @PathVariable Long id){
		
		return new ResponseEntity<>(addressService.updateAddress(address, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteAddress(@PathVariable Long id){
		
		return new ResponseEntity<>(addressService.deleteAddress(id),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
