package com.packt.webbi.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.packt.webbi.domain.Address;

public class AddressMapper implements RowMapper<Address> {

	   public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		        Address address = new Address();
		        
		        address.setId(rs.getLong("ID"));
		        address.setState(rs.getString("STATE"));
		        address.setDistrict(rs.getString("DISTRICT"));
		        address.setAddress(rs.getString("ADDRESS"));
		        return address;
		   }
}
