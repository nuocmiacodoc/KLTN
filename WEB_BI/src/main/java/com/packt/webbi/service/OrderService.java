package com.packt.webbi.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.packt.webbi.domain.Order;

public interface OrderService {

   Long saveOrder(Order order, HttpServletRequest request);
   
   List <Order> getAllOrders();
   
   List <Order> getAllOrdersByUsername(String username);
   
   Order getOrderById(String orderID);
   
   void saveRewardPoint(String username, BigDecimal totalPrice);
   
   BigDecimal getFinalPrice(String username, BigDecimal totalPrice);
   
   public void delete(String id);
}
