package com.packt.webbi.domain;

import java.io.Serializable;

public class ShippingDetail implements Serializable{

   private static final long serialVersionUID = 6350930334140807514L;
   
   private Long id;
   private String shippingDate;
   private Address shippingAddress;
   
   public ShippingDetail(Long id) {
	      this.id = id;
	   }
   
   public Long getId() {
      return id;
   }
   
   public void setId(long id) {
      this.id = id;
   }
   
   public ShippingDetail() {
      this.shippingAddress = new Address();
   }
   
   public String getShippingDate() {
      return shippingDate;
   }

   public void setShippingDate(String shippingDate) {
      this.shippingDate = shippingDate;
   }

   public Address getShippingAddress() {
      return shippingAddress;
   }

   public void setShippingAddress(Address shippingAddress) {
      this.shippingAddress = shippingAddress;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
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
      ShippingDetail other = (ShippingDetail) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      return true;
   }
}
