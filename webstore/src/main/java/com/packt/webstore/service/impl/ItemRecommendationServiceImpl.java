package com.packt.webstore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.service.ItemRecommendationService;

@Service
public class ItemRecommendationServiceImpl implements ItemRecommendationService{
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> getProductsRecommendation(String productId, String categoryId, String unitPrice) {
		int comparedValue = 2000000;
		String lowprice = String.valueOf(Integer.parseInt(unitPrice) - comparedValue);
		String highprice = String.valueOf(Integer.parseInt(unitPrice) + comparedValue);
		List<Product> recommendationProduct = productRepository.getRecommendationList(productId, categoryId, lowprice, highprice);
		
		List<Double> productReview = productRepository.getProductReview(productId, 5);

		for (Product item : recommendationProduct) {
			List<Double> comparedProductReview = productRepository.getProductReview(item.getProductId(), productReview.size());
			for(int i = 0; i <productReview.size(); i++) {
			try {
				comparedProductReview.get(i);
			}
			catch (Exception e) {
				comparedProductReview.add((double) 0);
			}
			}
		
			List<Double> list = new ArrayList<Double>();
			list.add((double) 3);
			list.add((double) 3);
			list.add((double) 2);
			list.add((double) 0);
			list.add((double) 5);
			double[] arr = list.stream().mapToDouble(d -> d).toArray();
		    double[] honda = {3, 3, 5, 5, 5};
		    double corr = new PearsonsCorrelation().correlation(honda , arr);    
		    
		    System.out.println(corr);
		// double corr = new PearsonsCorrelation().correlation(productReview.stream().mapToDouble(d -> d).toArray(), comparedProductReview.stream().mapToDouble(d -> d).toArray());
		 //System.out.println(corr);
		}
		
		System.out.println("Size: " + recommendationProduct.size());
		return null;
	}
}
