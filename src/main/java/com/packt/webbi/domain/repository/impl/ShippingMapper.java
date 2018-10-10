package com.packt.webbi.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.packt.webbi.domain.Address;
import com.packt.webbi.domain.ShippingDetail;

public class ShippingMapper implements RowMapper<ShippingDetail>{
	
	private AddressMapper addressMapper;
	 private NamedParameterJdbcTemplate jdbcTempleate;
	 
	public ShippingMapper(NamedParameterJdbcTemplate jdbcTempleate)
	{
		this.jdbcTempleate = jdbcTempleate;
		addressMapper = new AddressMapper();
	}

	   public ShippingDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Map<String, Object> params = new HashMap<String, Object>();
		      Long id = rs.getLong("ID");
		        ShippingDetail shippingDetail = new ShippingDetail(id);
		    
		       String getAddressSQL = String.format("SELECT * FROM address WHERE ID = '%d'", rs.getLong("SHIPPING_ADDRESS_ID"));
		       Address address = jdbcTempleate.queryForObject(getAddressSQL, params,addressMapper);
		       
		       System.out.println("Shipping date: " + rs.getString("SHIPPING_DATE"));
		       shippingDetail.setShippingDate(rs.getString("SHIPPING_DATE"));
		       shippingDetail.setShippingAddress(address);
		       
		       
		        return shippingDetail;
		   }
	
}
