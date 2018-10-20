package com.packt.webbi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webbi.domain.Customer;
import com.packt.webbi.service.CustomerService;

@RestController
@RequestMapping(value = "rest/admin/customers")
public class AdminCustomersRestController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	   public List<Customer> getAllCustomers() {
	      return customerService.getAllCustomers();
	   }
	
	@RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	   public void delete(@PathVariable(value = "customerId") String customerId) {
	      customerService.delete(customerId);
	   }
}
