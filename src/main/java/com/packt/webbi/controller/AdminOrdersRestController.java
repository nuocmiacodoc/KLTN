package com.packt.webbi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webbi.domain.Order;
import com.packt.webbi.service.OrderService;


@RestController
@RequestMapping(value = "rest/admin/orders")
public class AdminOrdersRestController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	   public List<Order> getAllOrders() {
	      return orderService.getAllOrders();
	   }
	
	@RequestMapping(value = "/{orderId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	   public void delete(@PathVariable(value = "orderId") String orderId) {
	      orderService.delete(orderId);
	   }
	
//	@RequestMapping(value = "/{filter}", method = RequestMethod.GET)
//	   public List<Order> getAllOrders() {
//	      return orderService.getAllOrders();
//	   }
	
//	@RequestMapping("/products/filter/{params}")
//	public String getProductsByFilter(@MatrixVariable(pathVar="params") Map<String,List<String>> filterParams, Model model) {
//	   model.addAttribute("products", productService.getProductsByFilter(filterParams));
//	   return "products";
//	}
}
