package com.packt.webbi.domain.repository;

import java.util.List;
import java.util.Map;

import com.packt.webbi.domain.Product;

public interface ProductRepository {

	List <Product> getAllProducts();
	
	void updateStock(String productId, long noOfUnits);
	
	List<Product> getProductsByCategory(String category);
	
	List<Product> getProductsByPage(String category,String brand, String lowprice, String highprice, int pageid, int totalproducts);
	
	int countProductPages(String category, String brand, String lowprice, String highprice);
	
	List<Product> getProductsByFilter(Map<String,List<String>> filterParams);
	
	Product getProductById(String productID);
	
	void addProduct(Product product);
	
	void update(Product product);
	   
	void delete(String id);
	
	List<Product> getRecommendationList(String productId, String categoryId, String lowprice, String highprice);
	
	List<Double> getProductReview(String productId, int quantity);
}
