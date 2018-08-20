package com.packt.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable{

   private static final long serialVersionUID = -3560539622417210365L;
   
   private Long orderId;
   private Cart cart;
   private Customer customer;
   private ShippingDetail shippingDetail;
   private String username;
   private float pointOfOrder;
   private BigDecimal finalPrice;
   
   public Order(Long id)
   {
	   this.orderId = id;
   }
   
   public Order() {
      this.customer = new Customer();
      this.shippingDetail = new ShippingDetail();
   }

   public Long getOrderId() {
      return orderId;
   }

   public void setOrderId(Long orderId) {
      this.orderId = orderId;
   }

   public Cart getCart() {
      return cart;
   }

   public void setCart(Cart cart) {
      this.cart = cart;
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }

   public ShippingDetail getShippingDetail() {
      return shippingDetail;
   }

   public void setShippingDetail(ShippingDetail shippingDetail) {
      this.shippingDetail = shippingDetail;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
      Order other = (Order) obj;
      if (orderId == null) {
         if (other.orderId != null)
            return false;
      } else if (!orderId.equals(other.orderId))
         return false;
      return true;
   }

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public BigDecimal getFinalPrice() {
	return finalPrice;
}

public void setFinalPrice(BigDecimal finalPrice) {
	this.finalPrice = finalPrice;
}

public float getPointOfOrder() {
	return pointOfOrder;
}

public void setPointOfOrder(float pointOfOrder) {
	this.pointOfOrder = pointOfOrder;
}
}
