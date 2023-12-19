package com.ntreddy.dd.ecommerce.dao.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntreddy.dd.ecommerce.entity.OrderItem;

public interface OrderItemDao {

	Page<OrderItem> findByOrder_Id(Long orderId, Pageable pageable);

	void deleteById(Long id);

	OrderItem save(OrderItem orderItem);

	OrderItem findById(Long id);

}
