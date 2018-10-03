package com.packt.webbi.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.packt.webbi.domain.Customer;

public class CustomerMapper implements RowMapper<Customer> {

	   public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Long id = rs.getLong("ID");
	        Customer customer = new Customer(id);
	        
	        customer.setEmail(rs.getString("EMAIL"));
	        customer.setName(rs.getString("NAME"));
	        customer.setPhoneNumber(rs.getString("PHONE_NUMBER"));
	        
	        return customer;
	   }
	
}
