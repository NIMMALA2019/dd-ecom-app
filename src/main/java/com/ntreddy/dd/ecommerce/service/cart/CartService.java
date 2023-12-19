package com.ntreddy.dd.ecommerce.service.cart;

import com.ntreddy.dd.ecommerce.entity.Cart;
import com.ntreddy.dd.ecommerce.entity.CartItem;

public interface CartService {
    Cart create(Cart cart);
    Cart addItem(Long cartId, CartItem cartItem);
    Cart removeItem(Long cartId, Long cartItemId);
    Cart getCartById(Long cartid);
    Cart completeCart(Long id);
    Cart getByCustomerId(Long id);
    void deleteByCustomerId(Long id);
}
