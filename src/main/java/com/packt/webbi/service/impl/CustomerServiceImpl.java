package com.packt.webbi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webbi.domain.Customer;
import com.packt.webbi.domain.repository.CustomerRepository;
import com.packt.webbi.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
private CustomerRepository customerRepository;

@Override
public List <Customer> getAllCustomers() {
	
	return customerRepository.getAllCustomers();
}

@Override
public void delete(String id) {
	// TODO Auto-generated method stub
	customerRepository.delete(id);
}
	
}
