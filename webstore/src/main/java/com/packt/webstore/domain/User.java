package com.packt.webstore.domain;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

   private static final long serialVersionUID = 2284040482222162898L;
   
   private String name;
   private String password;
   private String passwordConfirm;
   private int userpoint;
   private List<Role> roles;
   
   public User(String name) {
	   this.setName(name);
   }
   
   public User() {
      super();
   }
 
   
   public List<Role> getRoles() {
       return roles;
   }

   public void setRoles(List<Role> roles) {
       this.roles = roles;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }

public String getPasswordConfirm() {
	return passwordConfirm;
}

public void setPasswordConfirm(String passwordConfirm) {
	this.passwordConfirm = passwordConfirm;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getUserpoint() {
	return userpoint;
}

public void setUserpoint(int userpoint) {
	this.userpoint = userpoint;
}
}
