package com.packt.webstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;


@RestController
@RequestMapping(value = "market/rest/products")
public class ProductsRestController {

	@Autowired
	private ProductService productsService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	   public List<Product> read() {
	      return productsService.getAllProducts();
	   }

//	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
//	   public List<Product> readProductByCategory(@PathVariable(value = "categoryId") String categoryId) {
//		return productsService.getProductsByPage(categoryId, 1);
//	   }
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	   public Map<String, Object> readProductByCategory(@PathVariable(value = "categoryId") String categoryId, 
			   @RequestParam(value="page", required=false, defaultValue = "1") int pageId,
			   @RequestParam(value="brand", required=false) String brand,
			   @RequestParam(value="lowprice", required=false) String lowprice,
			   @RequestParam(value="highprice", required=false) String highprice) {
		 List<Product> list= productsService.getProductsByPage(categoryId, brand, lowprice,highprice,pageId);
		 int totalPages = productsService.countProductPages(categoryId, brand, lowprice, highprice);
		 Map<String, Object> object = new HashMap<String, Object>();
		 
		 object.put("listproducts", list);
		 object.put("totalPages", totalPages);
		 
		 
		 return object;
	   }
	
	@RequestMapping("/product")
	public Product getProductById(@RequestParam("id") String productId) {
	   return productsService.getProductById(productId);
	}
	
}
