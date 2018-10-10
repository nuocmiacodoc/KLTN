package com.packt.webbi.service;

import java.util.List;

import com.packt.webbi.domain.Customer;

public interface CustomerService {

	List <Customer> getAllCustomers();
	
	public void delete(String id);
}
