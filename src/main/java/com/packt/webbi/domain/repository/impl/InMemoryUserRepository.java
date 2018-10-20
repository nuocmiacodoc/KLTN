package com.packt.webbi.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webbi.domain.Role;
import com.packt.webbi.domain.User;
import com.packt.webbi.domain.repository.UserRepository;

@Repository
public class InMemoryUserRepository  implements UserRepository{

	   @Autowired
	   private NamedParameterJdbcTemplate jdbcTemplate;
	   
	   @Override
	   public User findByUserName(String name) {
		   
		   String SQL = "SELECT * FROM users WHERE USERNAME = :username";
		      Map<String, Object> params = new HashMap<String, Object>();
		      params.put("username", name);
		      try {
		        User result = jdbcTemplate.queryForObject(SQL, params, new UserMapper());
		        return result;
		      }
		      catch(Exception e) {System.out.println( e.getMessage());}
		        return null;
	   }
	   
	   public class UserMapper implements RowMapper<User> {
		      public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		         User user = new User();
		         user.setName(rs.getString("USERNAME"));
		         user.setPassword(rs.getString("PASSWORD"));
		         String SQL = "SELECT * FROM user_roles WHERE USERNAME = :username";
		         Map<String, Object> params = new HashMap<String, Object>();
		         params.put("username", user.getName());
		         List<Role> result = jdbcTemplate.query(SQL, params, new RoleMapper());
		         
		         user.setRoles(result);
		         return user;
		      }
		   }
	   
	   private static final class RoleMapper implements RowMapper<Role> {
		      public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		         Role role = new Role();
		         role.setName(rs.getString("USERNAME"));
		         role.setRole(rs.getString("USER_ROLE"));
		         role.setRoleId(rs.getInt("ROLE_ID"));
		         return role;
		      }
		   }
	   
	   @Override
	public void save(User user) {
	       String SQL_SAVE_users = "INSERT INTO users (USERNAME, "
	               + "PASSWORD,"
	               + "ENABLED, "
	               + "USER_POINT)"
	               + "VALUES (:username, :password, :enabled, :userpoint)";  
	         
	       String SQL_SAVE_user_roles = "INSERT INTO user_roles (ROLE_ID, "
	               + "USERNAME,"
	               + "USER_ROLE) "
	               + "VALUES (1, :username, :userrole)";
	       
	         Map<String, Object> params = new HashMap<>();
	         params.put("username", user.getName());  
	         params.put("password", user.getPassword());
	         params.put("userpoint",0);
	         params.put("enabled", 1);
	         params.put("userrole", "ROLE_USER"); 
	         jdbcTemplate.update(SQL_SAVE_users, params);
	         jdbcTemplate.update(SQL_SAVE_user_roles, params);
	}

	@Override
	public float getUserPoint(String username) {

		  String SQL = "SELECT USER_POINT FROM users WHERE USERNAME = :username";
	      Map<String, Object> params = new HashMap<String, Object>();
	      params.put("username", username);
	      try {
	        float point = jdbcTemplate.queryForObject(SQL, params, Float.class);
	        return point;
	      }
	      catch(Exception e) {System.out.println( e.getMessage());}
		return 0;
	}

	@Override
	public void saveUserpPoint(String username, Float point) {
		String SQL = "UPDATE users SET USER_POINT = :point WHERE USERNAME = :username";
		 Map<String, Object> params = new HashMap<String, Object>();
	      params.put("username", username);
	      params.put("point", point);
	      
	      jdbcTemplate.update(SQL, params);
	}

	@Override
	public void updateUserRating(int point, String username, String productId) {
		String UPDATE_SQL = "UPDATE review SET POINT = :point, USER_NAME = :username, PRODUCT_ID = :productId, DATE_MODIFIED = now() WHERE USER_NAME = :username AND PRODUCT_ID = :productId";
		String INSERT_SQL = "INSERT INTO review (PRODUCT_ID, USER_NAME, POINT, DATE_MODIFIED) VALUES (:productId, :username, :point, now())"; 
		String CHECKING_EXIST_SQL = "SELECT PRODUCT_ID FROM review WHERE PRODUCT_ID = :productId AND USER_NAME = :username ";
		
		Map<String, Object> params = new HashMap<String, Object>();
	      params.put("username", username);
	      params.put("point", point);
	      params.put("productId", productId);
	      
	 List<String> checkifnotexist = jdbcTemplate.queryForList(CHECKING_EXIST_SQL, params, String.class);
	 
	 if(checkifnotexist.isEmpty()) {
		 jdbcTemplate.update(INSERT_SQL, params);
	 }
	 else {
		 jdbcTemplate.update(UPDATE_SQL, params);
	 }
	}

	@Override
	public int getUserRating(String username, String productId) {
		String QUERY_SQL = "SELECT POINT FROM review WHERE PRODUCT_ID = :productId AND USER_NAME = :username";
		Map<String, Object> params = new HashMap<String, Object>();
	      params.put("username", username);
	      params.put("productId", productId);
	      try {
	    	  return jdbcTemplate.queryForObject(QUERY_SQL, params, Integer.class);
	      }
	      catch (Exception e) {
	    	  return 0;
	      }
	}
}
