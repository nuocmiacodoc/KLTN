package com.packt.webstore.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.packt.webstore")
public class RootApplicationContextConfig {

   @Bean
   public DataSource dataSource() {
	   DriverManagerDataSource ds = new DriverManagerDataSource();
	   	ds.setDriverClassName("com.mysql.jdbc.Driver");
	   	ds.setUrl("jdbc:mysql://localhost/webstore_database");
	    //ds.setUrl("jdbc:mysql://35.202.36.3/webstore_database");
	    ds.setUsername("root");
	    ds.setPassword("123456");
	    return ds;
   }
  
   @Bean
   public NamedParameterJdbcTemplate getJdbcTemplate() {
      return new NamedParameterJdbcTemplate(dataSource());
   }
}
