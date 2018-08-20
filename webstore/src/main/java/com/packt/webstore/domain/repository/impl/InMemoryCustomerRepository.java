package com.packt.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

   @Autowired
   private NamedParameterJdbcTemplate jdbcTempleate;
   
   @Override
	public List<Customer> getAllCustomers() {
	    Map<String, Object> params = new HashMap<String, Object>();
	    CustomerMapper customerMapper = new CustomerMapper();
	    
	      try {
	          List<Customer> result = jdbcTempleate.query("SELECT * FROM customer", params, customerMapper);
	          return result;
	      } catch (EmptyResultDataAccessException e) {
	            return null;
	      }
	   
	}
   
   @Override
   public void delete(String id) {
   	 String SQL_DELETE_CUSTOMER = "DELETE FROM customer WHERE ID = :id";
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
     
        jdbcTempleate.update(SQL_DELETE_CUSTOMER, params);  
   	
   }
   
}