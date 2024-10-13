package com.example.Practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Practice.entity.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
