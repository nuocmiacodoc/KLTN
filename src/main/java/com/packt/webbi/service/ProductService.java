package com.packt.webbi.service;

import java.util.List;
import java.util.Map;

import com.packt.webbi.domain.Product;

public interface ProductService {

//	void updateAllStock();
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategory(String category);
	
	List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	List<Product> getProductsByPage(String category, String brand, String lowprice,String highprice, int pageid);
	
	int countProductPages(String category, String brand, String lowprice, String highprice);
	
	Product getProductById(String productID);
	
	void addProduct(Product product);
	
	void update(String productId);
	   
	void delete(String id);
}
