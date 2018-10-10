package com.packt.webbi.domain;

import java.io.Serializable;

public class Customer implements Serializable{

   private static final long serialVersionUID = 2284040482222162898L;
   
   private Long customerId;
   private String name;
   private String email;
   private String phoneNumber;
   
   public Customer(Long id) {
	   this.customerId = id;
   }
   
   public Customer() {
      super();
   }
   
   public Customer(Long customerId, String name) {
      this();
      this.customerId = customerId;
      this.name = name;
   }

   public Long getCustomerId() {
      return customerId;
   }

   public void setCustomerId(long customerId) {
      this.customerId = customerId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
	      return email;
	   }

	   public void setEmail(String email) {
	      this.email = email;
	   }   
   
   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Customer other = (Customer) obj;
      if (customerId == null) {
         if (other.customerId != null)
            return false;
      } else if (!customerId.equals(other.customerId))
         return false;
      return true;
   }
}
