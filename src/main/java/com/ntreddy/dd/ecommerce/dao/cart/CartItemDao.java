package com.ntreddy.dd.ecommerce.dao.cart;

import com.ntreddy.dd.ecommerce.entity.CartItem;

public interface CartItemDao {

	void save(CartItem item);

	void deleteById(Long itemId);

	void deleteAllByCartId(Long id);

}
