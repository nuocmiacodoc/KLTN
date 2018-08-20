package com.packt.webstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ItemRecommendationService;
import com.packt.webstore.service.ProductService;

@RestController
@RequestMapping(value = "rest/products/recommendation")
public class ItemRecommendationRestController {

	@Autowired
	private ProductService productsService;
	@Autowired
	private ItemRecommendationService itemRecommendationService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	   public List<Product> read(
				@RequestParam(value="productId", required=false) String productId,
				@RequestParam(value="categoryId", required=false ) String categoryId,
				@RequestParam(value="unitPrice", required=false) String unitPrice) {
	      return itemRecommendationService.getProductsRecommendation(productId, categoryId, unitPrice);
} 
	}
