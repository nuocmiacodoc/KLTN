package com.packt.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;

@RestController
@RequestMapping(value = "rest/admin/products")
public class AdminProductsRestController {

	@Autowired
	private ProductService productsService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	   public List<Product> read() {
	      return productsService.getAllProducts();
	   }
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	   public List<Product> readProductByCategory(@PathVariable(value = "categoryId") String categoryId) {
		
		if(categoryId.equals("All"))
		{
			return productsService.getAllProducts();
		}
		else
			return productsService.getProductsByCategory(categoryId);
	   }	 
	
	@RequestMapping("/product")
	public Product getProductById(@RequestParam("id") String productId) {
	   return productsService.getProductById(productId);
	}
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	   public void delete(@PathVariable(value = "productId") String productId) {
	      productsService.delete(productId);
	   }	 
}
