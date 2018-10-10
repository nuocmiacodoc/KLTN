package com.packt.webbi.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webbi.domain.Product;
import com.packt.webbi.domain.repository.ProductRepository;
import com.packt.webbi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

   @Autowired
   private ProductRepository productRepository;
  
//   @Override
//   public void updateAllStock() {
//      List<Product> allProducts = productRepository.getAllProducts();
//     
//      for(Product product : allProducts) {
//         if(product.getUnitsInStock()<500)
//            productRepository.updateStock(product.getProductId(), product.getUnitsInStock()+1000);
//      }
//   }
   
   @Override
   public List<Product> getAllProducts() {
         return productRepository.getAllProducts();
   }
   
   public List<Product> getProductsByCategory(String category) {
	   return productRepository.getProductsByCategory(category);
	} 
   
   public List<Product> getProductsByPage(String category, String brand, String lowprice,String highprice, int pageid) {
	   int totalproducts = 8;
	   if(pageid==1){}
	   else{  
           pageid=(pageid-1)*totalproducts+1;  
       }  
	   return productRepository.getProductsByPage(category, brand, lowprice,highprice, pageid, totalproducts);
   }
   
   public int countProductPages(String category, String brand, String lowprice,String highprice) {
	   return (productRepository.countProductPages(category, brand, lowprice, highprice)/9) + 1;
   }
   
   public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
	      return productRepository.getProductsByFilter(filterParams);
	}
   
   @Override
   public Product getProductById(String productID) {
      return productRepository.getProductById(productID);
   }
   
   @Override
   public void addProduct(Product product) {
      productRepository.addProduct(product);
   }

   @Override
	public void update(String productId) {
		// TODO Auto-generated method stub
		
	}
   
   @Override
	public void delete(String id) {
		productRepository.delete(id);
	}
   
}
