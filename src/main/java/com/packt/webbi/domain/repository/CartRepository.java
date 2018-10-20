package com.packt.webbi.domain.repository;

import com.packt.webbi.domain.Cart;
import com.packt.webbi.dto.CartDto;

public interface CartRepository {

   void create(CartDto cartDto);
   
   Cart read(String id);
   
   void update(String id, CartDto cartDto);
   
   void delete(String id);

   void addItem(String cartId, String productId);

   void removeItem(String cartId, String productId);
   
   void clearCart(String cartId);
   
   int countCartItems (String id);
}
