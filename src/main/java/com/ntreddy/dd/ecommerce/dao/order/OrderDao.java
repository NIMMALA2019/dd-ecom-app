package com.ntreddy.dd.ecommerce.dao.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntreddy.dd.ecommerce.entity.Order;

public interface OrderDao {

	Order createOrder(Object order);

	Page<Order> findAll(Pageable pageable);

	Order findById(Long id);

	Page<Order> findByCustomerId(Long customerId, Pageable pageable);

	void deleteById(Long id);

	

}
