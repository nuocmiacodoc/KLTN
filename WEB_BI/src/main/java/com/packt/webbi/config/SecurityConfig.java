package com.packt.webbi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
 
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Autowired
	    private UserDetailsService userDetailsService;
	
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
     //   auth.inMemoryAuthentication().withUser("maithi").password("123456").roles("USER");
       // auth.inMemoryAuthentication().withUser("admin").password("123456").roles("USER","ADMIN");
        auth.userDetailsService(userDetailsService).getUserDetailsService();
    }
    
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
     
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
  
       httpSecurity.formLogin().loginPage("/login")
                   .usernameParameter("userId")
                   .passwordParameter("password");
       
       httpSecurity.formLogin().defaultSuccessUrl("/market/products")
                    .failureUrl("/login?error");
       
       httpSecurity.logout().logoutSuccessUrl("/login?logout");
       
       httpSecurity.exceptionHandling().accessDeniedPage("/login?accessDenied");
       
       httpSecurity.authorizeRequests()
          .antMatchers("/").permitAll()
          .antMatchers("/**/market/**").permitAll()
          .antMatchers("/**/admin/**").access("hasRole('ADMIN')");      
         // .antMatchers("/**/market/**").access("hasRole('USER')")     
       
       httpSecurity.csrf().disable();
    }
}
