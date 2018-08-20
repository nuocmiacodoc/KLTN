package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Order;

public interface OrderRepository {
   long saveOrder(Order order);
   
   List <Order> getAllOrders();
   
   List <Order> getAllOrdersByUserName(String username);
   
   Order getOrderById(String orderID);
   
   void delete(String id);
}
