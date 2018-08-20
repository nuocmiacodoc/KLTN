package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;

@Repository
public class InMemoryProductRepository implements ProductRepository{
  
   @Autowired
   private NamedParameterJdbcTemplate jdbcTemplate;

   @Override
   public List<Product> getAllProducts() {
      Map<String, Object> params = new HashMap<String, Object>();
        List<Product> result = jdbcTemplate.query("SELECT * FROM products", params, new ProductMapper());
      
        return result;
   }

   private static final class ProductMapper implements RowMapper<Product> {
      public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
         Product product = new Product();
         product.setProductId(rs.getString("ID"));
         product.setName(rs.getString("NAME"));
         product.setDescription(rs.getString("DESCRIPTION"));
         product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
         product.setManufacturer(rs.getString("MANUFACTURER"));
         product.setCategory(rs.getString("CATEGORY"));
         product.setQuality(rs.getString("QUALITY"));
         product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
         product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
         product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
         return product;
      }
   }
   
   @Override
   public void updateStock(String productId, long noOfUnits) { 
      String SQL = "UPDATE products SET UNITS_IN_STOCK = :unitsInStock WHERE ID = :id"; 
      Map<String, Object> params = new HashMap<>();
      params.put("unitsInStock", noOfUnits); 
      params.put("id", productId); 
     
      jdbcTemplate.update(SQL, params); 
   }
   
   @Override
   public List<Product> getProductsByCategory(String category) {
      String SQL = "SELECT * FROM products WHERE CATEGORY = :category";
      Map<String, Object> params = new HashMap<String, Object>();
      params.put("category", category);

      return jdbcTemplate.query(SQL, params, new ProductMapper());
   }
   
	@Override
	public List<Product> getRecommendationList(String productId, String categoryId, String lowprice, String highprice) {
		System.out.println(highprice);
		System.out.println(lowprice);
		   String SQL = "SELECT * FROM products WHERE CATEGORY = :categoryId "
		    		//+  "AND ID != :productId"
		    		+  "AND (:lowprice IS NULL OR UNIT_PRICE >= :lowprice) "
		    		+  "AND (:highprice IS NULL OR UNIT_PRICE <= :highprice) ";
		      Map<String, Object> params = new HashMap<String, Object>();
		      params.put("categoryId", categoryId);
		      params.put("productId", productId);
		      params.put("lowprice", lowprice);
		      params.put("highprice", highprice);
		      return jdbcTemplate.query(SQL, params, new ProductMapper());
	}
   
   @Override
   public List<Product> getProductsByPage(String category,String brand, String lowprice, String highprice,  int pageid, int totalproducts) {
     // System.out.println("cate: " +category + " brand: "+ brand +" lowprice: "+ lowprice + " highprice: " +highprice);
	   String SQL = "SELECT * FROM products WHERE CATEGORY = :category "
    		+  "AND (:brand IS NULL OR  MANUFACTURER = :brand) "
    		+  "AND (:lowprice IS NULL OR UNIT_PRICE >= :lowprice) "
    		+  "AND (:highprice IS NULL OR UNIT_PRICE <= :highprice) "
      		//+ "AND (MANUFACTURER IS MANUFACTURER = :brand) "
    		//+ "AND UNIT_PRICE = :price "
      		+ "limit "+(pageid-1)+","+totalproducts;
	   
	//  System.out.println(SQL);
      Map<String, Object> params = new HashMap<String, Object>();
      params.put("category", category);
      params.put("brand", brand);
      params.put("lowprice", lowprice);
      params.put("highprice", highprice);
      

      return jdbcTemplate.query(SQL, params, new ProductMapper());
   }
   
   @Override
   public int countProductPages(String category, String brand, String lowprice, String highprice) {
//	   System.out.println(category + " br: " + brand + " price: " + lowprice);
	   String SQL = "SELECT COUNT(*) FROM products WHERE CATEGORY IN (:category) "
			+  "AND (:brand IS NULL OR  MANUFACTURER = :brand) "
			+  "AND (:lowprice IS NULL OR UNIT_PRICE >= :lowprice) "
	    	+  "AND (:highprice IS NULL OR UNIT_PRICE <= :highprice) ";
			  // + "AND MANUFACTURER = :brand "
	    	//	+ "AND UNIT_PRICE = :price ";
	   Map<String, Object> params = new HashMap<String, Object>();
	   params.put("category", category);
	   params.put("brand", brand);
	   params.put("lowprice", lowprice);
	   params.put("highprice", highprice);
	   
	   return jdbcTemplate.queryForObject(SQL, params, Integer.class);
   }
   
   @Override
   public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
      String SQL = "SELECT * FROM products WHERE CATEGORY IN ( :categories ) AND MANUFACTURER IN ( :brands)";

      return jdbcTemplate.query(SQL, filterParams, new ProductMapper());
   }
   
   @Override
   public Product getProductById(String productID) {
      String SQL = "SELECT * FROM products WHERE ID = :id";  
      Map<String, Object> params = new HashMap<>();
      params.put("id", productID);  
         
      try {
         return jdbcTemplate.queryForObject(SQL, params, new ProductMapper());
      } catch (DataAccessException e) {
         throw new ProductNotFoundException(productID);
      }   
   }

   
   @Override
   public void addProduct(Product product) {
         String SQL = "INSERT INTO products (ID, "
               + "NAME,"
               + "DESCRIPTION,"
               + "UNIT_PRICE,"
               + "MANUFACTURER,"
               + "CATEGORY,"
               + "QUALITY,"
               + "UNITS_IN_STOCK,"
               + "UNITS_IN_ORDER,"
               + "DISCONTINUED) "
               + "VALUES (:id, :name, :desc, :price, :manufacturer, :category, :quality, :inStock, :inOrder, :discontinued)";  
         
         Map<String, Object> params = new HashMap<>();
         params.put("id", product.getProductId());  
         params.put("name", product.getName());  
         params.put("desc", product.getDescription());  
         params.put("price", product.getUnitPrice());  
         params.put("manufacturer", product.getManufacturer());  
         params.put("category", product.getCategory());  
         params.put("quality", product.getQuality());  
         params.put("inStock", product.getUnitsInStock());  
         params.put("inOrder", product.getUnitsInOrder());  
         params.put("discontinued", product.isDiscontinued());  

         jdbcTemplate.update(SQL, params);     
      }
   
	@Override
	public List<Double> getProductReview(String productId, int quantity) {
		String SQL = "Select POINT from review where PRODUCT_ID = :productId"
				+ " limit 0, :quantity";
		 Map<String, Object> params = new HashMap<>();
         params.put("productId", productId);
         params.put("quantity", quantity);
		return jdbcTemplate.queryForList(SQL,params,Double.class);
	}
    
    @Override
 	public void delete(String id) {

    	 String SQL_DELETE_PRODUCT = "DELETE FROM products WHERE ID = :id";
         
         Map<String, Object> params = new HashMap<String, Object>();
         params.put("id", id);
      
         jdbcTemplate.update(SQL_DELETE_PRODUCT, params);  
 	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}
}

