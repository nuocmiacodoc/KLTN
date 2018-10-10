package com.packt.webbi.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.packt.webbi.domain.Cart;
import com.packt.webbi.domain.Customer;
import com.packt.webbi.domain.Order;
import com.packt.webbi.domain.ShippingDetail;
import com.packt.webbi.service.ProductService;

public class OrderMapper implements RowMapper<Order> {

	   private CartMapper cartMapper;
	   private CustomerMapper customerMapper;
	   private ShippingMapper shippingMapper;
	   private NamedParameterJdbcTemplate jdbcTempleate;
	   
	   public OrderMapper(NamedParameterJdbcTemplate jdbcTempleate, ProductService productService) {
	      this.jdbcTempleate = jdbcTempleate;
	      cartMapper = new CartMapper(jdbcTempleate, productService);
	      customerMapper = new CustomerMapper();
	      shippingMapper = new ShippingMapper(jdbcTempleate);
	   }

	   public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		   
		   Map<String, Object> params = new HashMap<String, Object>();
	      Long id = rs.getLong("ID");
	      
	        Order order = new Order(id);
	        
	        String getCustomerInfoSQL = String.format("SELECT * FROM customer WHERE ID = '%d'", rs.getLong("CUSTOMER_ID"));
	        String getShippingDetailSQL = String.format("SELECT * FROM shipping_detail WHERE ID = '%d'", rs.getLong("SHIPPING_DETAIL_ID"));
	        String getCartSQL = String.format("SELECT * FROM cart WHERE ID = '%s'", rs.getString("CART_ID"));

	        Customer customer = jdbcTempleate.queryForObject(getCustomerInfoSQL,params,customerMapper);
	        ShippingDetail shippingDetail = jdbcTempleate.queryForObject(getShippingDetailSQL,params,shippingMapper);
	        Cart cart = jdbcTempleate.queryForObject(getCartSQL,params,cartMapper);
	        
	        order.setUsername(rs.getString("USER_NAME"));
	        order.setFinalPrice(rs.getBigDecimal("FINAL_PRICE"));
	        order.setCustomer(customer);
	        order.setShippingDetail(shippingDetail);
	        order.setCart(cart);
	        return order;
	   }
}
