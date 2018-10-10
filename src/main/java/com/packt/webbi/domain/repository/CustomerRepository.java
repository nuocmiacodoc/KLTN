package com.packt.webbi.domain.repository;
import java.util.List;

import com.packt.webbi.domain.Customer;

public interface CustomerRepository {

	   List <Customer> getAllCustomers();
	   
	   void delete(String id);
	}
