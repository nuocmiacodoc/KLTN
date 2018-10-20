package com.packt.webbi.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webbi.domain.Order;
import com.packt.webbi.domain.repository.OrderRepository;
import com.packt.webbi.domain.repository.UserRepository;
import com.packt.webbi.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
   
   @Autowired
   private OrderRepository orderRepository;
   
   @Autowired
   private UserRepository userRepository;
   
   @Override
   public Long saveOrder(Order order, HttpServletRequest request) {
	   Long id = orderRepository.saveOrder(order);
	   request.changeSessionId();
      return id;
   }
   
   @Override
   public List <Order> getAllOrders()
   {
	   return orderRepository.getAllOrders();
   }
   
   @Override
   
   public Order getOrderById(String orderID) {
	   return orderRepository.getOrderById(orderID);
   }

@Override
public void saveRewardPoint(String username, BigDecimal totalPrice) {
	if(!username.equals("anonymousUser")) {
	float rewardpoint = (float) ((totalPrice.doubleValue()/500000000.f) * 50);
	userRepository.saveUserpPoint(username, rewardpoint + userRepository.getUserPoint(username));
	}
}

@Override
public BigDecimal getFinalPrice(String username, BigDecimal totalPrice) {
	if(!username.equals("anonymousUser")) {
		float point =  userRepository.getUserPoint(username);
		long price = (long)(totalPrice.floatValue() - (totalPrice.floatValue()*point)/100.f);
		BigDecimal value = new BigDecimal(Long.toString(price));
		return value;
	}
	return totalPrice;
}

@Override
public List<Order> getAllOrdersByUsername(String username) {

	return orderRepository.getAllOrdersByUserName(username);
}

@Override
public void delete(String id) {
	orderRepository.delete(id);
	
}
}
