package com.packt.webstore.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;
import com.packt.webstore.validator.ProductValidator;

@Controller
@RequestMapping(value = "/admin/dashboard")
public class AdminDashboardController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductValidator productValidator;
	   
   @RequestMapping(value = "", method = RequestMethod.GET)
   public String initDashBoard(Model model) {
	   if(!model.containsAttribute("categoryId"))
	  model.addAttribute("categoryId", "products");
      return "dashboard";
   }
   
   @RequestMapping(value = "products/add", method = RequestMethod.GET)
   public String updateProduct(@RequestParam("id") String productId,Model model) {
	   Product newProduct;
	  if(productId == "")
	  {
		  model.addAttribute("pagename", "Add product");
		  model.addAttribute("categoryId", "products");
		  model.addAttribute("productID", "");
		  newProduct  = new Product();
	  }
	  else
	  {
		  model.addAttribute("categoryId", "products");
		  model.addAttribute("pagename", "Update product");
		  model.addAttribute("productID", productId);
		  newProduct = productService.getProductById(productId);
	  }
	  
	  model.addAttribute("newProduct", newProduct);
	  model.addAttribute("productId",productId);
      return "addProduct";
   }
   
	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@RequestParam("id") String productId, @ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result, HttpServletRequest request) {
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
		      if(productId != "")
		      {
		    	  productService.delete(newProduct.getProductId());
		      }
	   productService.addProduct(newProduct);
	   return "redirect:/admin/dashboard";
	}
	
	   @RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	   public String processDashBoardByCategory(@PathVariable(value = "categoryId") String categoryId, Model model, RedirectAttributes redirectAttributes) {
		   redirectAttributes.addFlashAttribute("categoryId", categoryId);
	      return "redirect:/admin/dashboard";
	   }  
	   
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
	      binder.setValidator(productValidator);
	      binder.setAllowedFields(
	    		 "id",
	    		"productId",
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
}
