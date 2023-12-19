package com.ntreddy.dd.ecommerce.dao.cart;

import com.ntreddy.dd.ecommerce.entity.Cart;

public interface CartDao {

	Long save(Cart cart);

	Cart findByCartId(Long id);

	Cart findByCustomerId(Long id);

	void deleteByCustomerId(Long id);

}
