package com.annaseva.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.annaseva.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
