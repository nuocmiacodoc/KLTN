package com.packt.webbi.domain.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.packt.webbi.domain.Address;
import com.packt.webbi.domain.Customer;
import com.packt.webbi.domain.Order;
import com.packt.webbi.domain.ShippingDetail;
import com.packt.webbi.domain.repository.OrderRepository;
import com.packt.webbi.service.ProductService;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

   @Autowired
   private NamedParameterJdbcTemplate jdbcTempleate;

   @Autowired
   private ProductService productService;
   
   @Override
   public long saveOrder(Order order) {
      
       Long customerId = saveCustomer(order.getCustomer());
       Long shippingDetailId = saveShippingDetail(order.getShippingDetail());
       
       order.getCustomer().setCustomerId(customerId);
       order.getShippingDetail().setId(shippingDetailId);
       
       long createdOrderId = createOrder(order);
     //  CartService.clearCart(order.getCart().getId());
       
       return createdOrderId;
   }
   
   @Override
   public List <Order> getAllOrders(){
	    Map<String, Object> params = new HashMap<String, Object>();
	    OrderMapper orderMapper = new OrderMapper(jdbcTempleate, productService);
	    
	      try {
	          List<Order> result = jdbcTempleate.query("SELECT * FROM orders", params, orderMapper);
	          return result;
	      } catch (EmptyResultDataAccessException e) {
	            return null;
	      }
   }
   
   @Override
   public List<Order> getAllOrdersByUserName(String username) {

	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("username", username);
	    OrderMapper orderMapper = new OrderMapper(jdbcTempleate, productService);
	    
	      try {
	          List<Order> result = jdbcTempleate.query("SELECT * FROM orders WHERE USER_NAME =:username", params, orderMapper);
	          return result;
	      } catch (EmptyResultDataAccessException e) {}
	   return null;
   }
   
   @Override
   public Order getOrderById(String orderID) {
	   Map<String, Object> params = new HashMap<String, Object>();
	   params.put("id", orderID);  
	    OrderMapper orderMapper = new OrderMapper(jdbcTempleate, productService);
	    
	      try {
	          Order result = jdbcTempleate.queryForObject("SELECT * FROM orders WHERE ID = :id", params, orderMapper);
	          return result;
	      } catch (EmptyResultDataAccessException e) {
	            return null;
	      }
   }
	   
   
   private long saveShippingDetail(ShippingDetail shippingDetail) {
      long addressId = saveAddress(shippingDetail.getShippingAddress());
      
      String SQL = "INSERT INTO shipping_detail(SHIPPING_DATE,SHIPPING_ADDRESS_ID) "
            + "VALUES (:shippingDate, :addressId)";

      Map<String, Object> params = new HashMap<String, Object>();
      params.put("shippingDate", shippingDetail.getShippingDate());
      params.put("addressId", addressId);

      SqlParameterSource paramSource = new MapSqlParameterSource(params);
      
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTempleate.update(SQL, paramSource,keyHolder, new String[]{"ID"});
      
      return keyHolder.getKey().longValue();
   }

   private long saveCustomer(Customer customer) {
      
      String SQL = "INSERT INTO customer(NAME,PHONE_NUMBER,EMAIL) "
            + "VALUES (:name, :phoneNumber,:email)";

      Map<String, Object> params = new HashMap<String, Object>();
      params.put("name", customer.getName());
      params.put("phoneNumber", customer.getPhoneNumber());
      params.put("email", customer.getEmail());

      SqlParameterSource paramSource = new MapSqlParameterSource(params);
      
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTempleate.update(SQL, paramSource,keyHolder, new String[]{"ID"});
      
      return keyHolder.getKey().longValue();
   }

   private long saveAddress(Address address) {
      String SQL = "INSERT INTO address(STATE,DISTRICT,ADDRESS) "
            + "VALUES (:state, :district, :address)";

      Map<String, Object> params = new HashMap<String, Object>();
      params.put("state", address.getState());
      params.put("district", address.getDistrict());
      params.put("address", address.getAddress());

      SqlParameterSource paramSource = new MapSqlParameterSource(params);
      
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTempleate.update(SQL, paramSource,keyHolder, new String[]{"ID"});
      
      return keyHolder.getKey().longValue();
   }

   private long createOrder(Order order) {
      String SQL = "INSERT INTO orders(CART_ID,CUSTOMER_ID,SHIPPING_DETAIL_ID, USER_NAME, FINAL_PRICE) "
            + "VALUES (:cartId, :customerId, :shippingDetailId, :username, :finalPrice)";

      Map<String, Object> params = new HashMap<String, Object>();
      params.put("id", order.getOrderId());
      params.put("cartId", order.getCart().getId());
      params.put("customerId", order.getCustomer().getCustomerId());
      params.put("shippingDetailId", order.getShippingDetail().getId());
      params.put("username", order.getUsername());
      params.put("finalPrice", order.getFinalPrice());

      SqlParameterSource paramSource = new MapSqlParameterSource(params);
      
      KeyHolder keyHolder = new GeneratedKeyHolder();
      jdbcTempleate.update(SQL, paramSource,keyHolder, new String[]{"ID"});
      
      return keyHolder.getKey().longValue();
   }

@Override
public void delete(String id) {
	 String SQL_DELETE_ORDER = "DELETE FROM orders WHERE ID = :id";
     
     Map<String, Object> params = new HashMap<String, Object>();
     params.put("id", id);
  
     jdbcTempleate.update(SQL_DELETE_ORDER, params);  
	
}


   
   
   
}
