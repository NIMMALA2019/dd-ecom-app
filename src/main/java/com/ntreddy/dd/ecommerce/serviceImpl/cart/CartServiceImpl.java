package com.ntreddy.dd.ecommerce.serviceImpl.cart;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntreddy.dd.ecommerce.dao.cart.CartDao;
import com.ntreddy.dd.ecommerce.dao.cart.CartItemDao;
import com.ntreddy.dd.ecommerce.dao.catalog.ProductDao;
import com.ntreddy.dd.ecommerce.dao.order.OrderDao;
import com.ntreddy.dd.ecommerce.dto.response.catalog.ProductResponse;
import com.ntreddy.dd.ecommerce.entity.Cart;
import com.ntreddy.dd.ecommerce.entity.CartItem;
import com.ntreddy.dd.ecommerce.exception.AlreadyExistException;
import com.ntreddy.dd.ecommerce.mapper.CommonMapper;
import com.ntreddy.dd.ecommerce.service.cart.CartService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

	@Autowired
    private CartDao cartDao;
	@Autowired
	private CartItemDao cartItemDao;
	@Autowired
	private CommonMapper basicMapper;
	@Autowired
    private OrderDao orderClient;
	@Autowired
    private ProductDao productClient;

    @Override
    public Cart create(Cart cart) {
        Cart existingCart = getByCustomerId(cart.getCustomer_id());
        if(null!=existingCart.getCustomer_id()) {
            throw new AlreadyExistException("Cart for customer already exist");
        }
        Long id= cartDao.save(cart);
		return cartDao.findByCartId(id);
    }

    private BigDecimal calculatePrice(BigDecimal price, int quantity) {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public Cart addItem(Long cartId, CartItem cartItem) {
        Cart cart = getCartById(cartId);
        ProductResponse productResponse= basicMapper.convertTo(productClient.findById(cartItem.getProduct_id()), ProductResponse.class);
        Optional<CartItem> existingItem = cart.getCartItems().stream().filter(cartItem::equals).findFirst();
        existingItem.ifPresentOrElse( 
			(item) -> { 
				item.setQuantity(item.getQuantity() + cartItem.getQuantity());
				item.addPrice(calculatePrice(productResponse.getPrice(), cartItem.getQuantity()));
				System.out.println( "Value is present, its: "+ item.getPrice()); 
				cartItemDao.save(item);
				}, 
			() ->	{
				System.out.println("Value is empty"); 
				cart.addItem(cartItem);
				cartItem.setCart(cart);
				cartItem.setPrice(calculatePrice(productResponse.getPrice(), cartItem.getQuantity()));
				cartItemDao.save(cartItem);
				System.out.println("Value is empty"); 
			}
        ); 
        Long id= cartDao.save(cart);
		return cartDao.findByCartId(id);
//        return cartDao.save(cart);
    }

    @Override
    public Cart removeItem(Long cartId, Long itemId) {
        Cart cart = getCartById(cartId);
        cart.removeItem(itemId);
        cartItemDao.deleteById(itemId);
        Long id= cartDao.save(cart);
		return cartDao.findByCartId(id);
//        return cartDao.save(cart);
    }

    @Override
    public Cart getCartById(Long cartid) {
        return cartDao.findByCartId(cartid);
    }

    @Override
    @Transactional
    public Cart completeCart(Long id) {
        Cart cart = getCartById(id);
        basicMapper.convertTo(orderClient.createOrder(cart), Object.class);
//        orderClient.create(basicMapper.convertTo(cart, CartResponse.class));
        //        Clear cart items
        cartItemDao.deleteAllByCartId(id);
        cart.setCartItems(new ArrayList<>());
        return cart;
    }

    @Override
    public Cart getByCustomerId(Long id) {
        return cartDao.findByCustomerId(id);
    }

    @Override
    public void deleteByCustomerId(Long id) {
    	cartDao.deleteByCustomerId(id);
    }
}
