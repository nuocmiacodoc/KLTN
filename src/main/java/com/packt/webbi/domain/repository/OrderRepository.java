package com.packt.webbi.domain.repository;

import java.util.List;

import com.packt.webbi.domain.Order;

public interface OrderRepository {
   long saveOrder(Order order);
   
   List <Order> getAllOrders();
   
   List <Order> getAllOrdersByUserName(String username);
   
   Order getOrderById(String orderID);
   
   void delete(String id);
}
