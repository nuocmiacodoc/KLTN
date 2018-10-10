package com.packt.webbi.controller;

import java.io.File;
import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webbi.domain.Product;
import com.packt.webbi.exception.ProductNotFoundException;
import com.packt.webbi.service.ProductService;
import com.packt.webbi.validator.ProductValidator;

@RestController
@RequestMapping("market")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductValidator productValidator;

	@RequestMapping("/products")
	public String list(Model model) {
	   model.addAttribute("products", productService.getAllProducts());
	   return "products";
	}
	
//	@RequestMapping("/update/stock")
//	public String updateStock(Model model) {
//	   productService.updateAllStock();
//	   return "redirect:/market/products";
//	}
	
	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable(value = "category") String categoryId, 
			@RequestParam(value="page", required=false, defaultValue = "1") int pageId,
			@RequestParam(value="brand", required=false ) String brand,
			@RequestParam(value="lowprice", required=false) String lowprice,
			@RequestParam(value="highprice", required=false) String highprice) {
		
		int totalPages = productService.countProductPages(categoryId, brand, lowprice, highprice);
	
	   model.addAttribute("totalPages", totalPages);
	   model.addAttribute("categoryId", categoryId);
	   model.addAttribute("brand", brand);
	   model.addAttribute("lowprice", lowprice);
	   model.addAttribute("highprice", highprice);
	   model.addAttribute("products",productService.getProductsByPage(categoryId,brand,lowprice,highprice, pageId));
	   return "showbycategory";
	}
	
	@RequestMapping("/products/filter/{params}")
	public String getProductsByFilter(@MatrixVariable(pathVar="params") Map<String,List<String>> filterParams, Model model) {
	   model.addAttribute("products", productService.getProductsByFilter(filterParams));
	   return "showbycategory";
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model, Principal principal) {
		String username = "";
		try {
		username = principal.getName();
		}
		catch(Exception e)
		{
		}
		model.addAttribute("username", username);
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
	   Product newProduct = new Product();
	   model.addAttribute("newProduct", newProduct);
	   return "addProduct";
	}
	   
	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			   return "addProduct";
		}
		
		String[] suppressedFields = result.getSuppressedFields();
		   if (suppressedFields.length > 0) {
		      throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		   }
		   
		   MultipartFile productImage = newProduct.getProductImage();
		   String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		         
		      if (productImage!=null && !productImage.isEmpty()) {
		          try {
		            productImage.transferTo(new File(rootDirectory+"resources\\images\\"+ newProduct.getProductId() + ".png"));
		          } catch (Exception e) {
		         throw new RuntimeException("Product Image saving failed", e);
		      }
		      }

	
	   productService.addProduct(newProduct);
	   return "redirect:/market/products";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
	      binder.setValidator(productValidator);
	      binder.setAllowedFields("productId",
	            "name",
	            "unitPrice",
	            "description",
	            "manufacturer",
	            "category",
	            "unitsInStock",
	            "quality",
	            "productImage",
	            "language");
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("invalidProductId", exception.getProductId());
	    mav.addObject("exception", exception);
	    mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
	    mav.setViewName("productNotFound");
	    return mav;
	}
	
	@RequestMapping("/products/invalidPromoCode")
	public String invalidPromoCode() {
	      return "invalidPromoCode";
	}
}
