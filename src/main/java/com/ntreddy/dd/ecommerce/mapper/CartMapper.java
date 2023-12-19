package com.ntreddy.dd.ecommerce.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ntreddy.dd.ecommerce.dto.request.cart.CartItemRequest;
import com.ntreddy.dd.ecommerce.dto.request.cart.CartRequest;
import com.ntreddy.dd.ecommerce.dto.response.cart.CartResponse;
import com.ntreddy.dd.ecommerce.entity.Cart;
import com.ntreddy.dd.ecommerce.entity.CartItem;
import com.ntreddy.dd.ecommerce.service.cart.CartService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CartMapper {

	@Autowired
    private CommonMapper basicMapper;
	
	@Autowired
    private CartService cartService;

    public CartResponse create(CartRequest cartRequest) {
        Cart cart = basicMapper.convertTo(cartRequest, Cart.class);
        return basicMapper.convertTo(cartService.create(cart), CartResponse.class);
    }

    public CartResponse addItem(Long cartId, CartItemRequest cartItemRequest) {
        Cart cart = cartService.addItem(cartId, basicMapper.convertTo(cartItemRequest, CartItem.class));
        return basicMapper.convertTo(cart, CartResponse.class);
    }

    public CartResponse removeItem(Long cartId, Long itemId) {
        return basicMapper.convertTo(cartService.removeItem(cartId, itemId), CartResponse.class);
    }

    public CartResponse getCartById(Long cartid) {
        return basicMapper.convertTo(cartService.getCartById(cartid), CartResponse.class);
    }

    public CartResponse completeCart(Long id) {
        return basicMapper.convertTo(cartService.completeCart(id), CartResponse.class);
    }

    public CartResponse getByCustomerId(Long id) {
        return basicMapper.convertTo(cartService.getByCustomerId(id), CartResponse.class);
    }

    public void deleteByCustomerId(Long id) {
        cartService.deleteByCustomerId(id);
    }
}
