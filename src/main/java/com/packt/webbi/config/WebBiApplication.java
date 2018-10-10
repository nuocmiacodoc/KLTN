package com.packt.webbi.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.validation.Validator;

import com.packt.webbi.validator.ProductValidator;
import com.packt.webbi.validator.UnitsInStockValidator;

@ComponentScan("com.packt.webbi")
@SpringBootApplication
public class WebBiApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
        return builder.sources(WebBiApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(WebBiApplication.class, args);
	}
	
    @Bean
    public ProductValidator productValidator () {
       Set<Validator> springValidators = new HashSet<>();
       springValidators.add(new UnitsInStockValidator());
       
       ProductValidator productValidator = new ProductValidator();
       productValidator.setSpringValidators(springValidators);
       
       return productValidator;
    }
}
