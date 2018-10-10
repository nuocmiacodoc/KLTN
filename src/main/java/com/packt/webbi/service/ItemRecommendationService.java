package com.packt.webbi.service;

import java.util.List;

import com.packt.webbi.domain.Product;

public interface ItemRecommendationService {
	List<Product> getProductsRecommendation(String productId, String categoryId, String unitPrice);
}
