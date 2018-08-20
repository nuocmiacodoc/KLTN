package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Product;

public interface ItemRecommendationService {
	List<Product> getProductsRecommendation(String productId, String categoryId, String unitPrice);
}
