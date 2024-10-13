package com.example.Practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.Practice.bean.ResponseBean;
import com.example.Practice.entity.Address;
import com.example.Practice.exception.EntityNotFound;
import com.example.Practice.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public ResponseBean saveAddress(Address address) {

		ResponseBean responseBean = new ResponseBean();

		if (ObjectUtils.isEmpty(address)) {

			throw new EntityNotFound("Address not save");

		}

		Address addressResponse = addressRepository.save(address);
		responseBean.setData(addressResponse);
		responseBean.setMessage("Data save");
		return responseBean;

	}

	public ResponseBean fetchByIdAddress(Long id) {
		ResponseBean responseBean = new ResponseBean();
		Address address = addressRepository.findById(id).get();
		responseBean.setData(address);
		responseBean.setMessage("Data fetch");
		return responseBean;

	}

	public ResponseBean fetchAllAddress() {
		ResponseBean responseBean = new ResponseBean();
		List<Address> addressList = addressRepository.findAll();
		responseBean.setData(addressList);
		responseBean.setMessage("Data fetch");
		return responseBean;

	}

	public ResponseBean updateAddress(Address address, Long id) {
		ResponseBean responseBean = new ResponseBean();
		Address addressResponse = addressRepository.findById(id).get();
		addressResponse.setAddressLine(address.getAddressLine());
		addressResponse.setCity(address.getCity());
		addressResponse.setPincode(address.getPincode());
		Address save = addressRepository.save(addressResponse);
		
		responseBean.setData(save);
		responseBean.setMessage("Data fetch");
		return responseBean;

	}

	public String deleteAddress(Long id) {

		addressRepository.deleteById(id);
		return "data deleted";

	}

}
