package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.service.OrderService;

@Controller
@RequestMapping("orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping("/details")
	public String getOrderById(@RequestParam("id") String orderId, Model model) {
	   model.addAttribute("order", orderService.getOrderById(orderId));
	   return "orderDetails";
	}
}
