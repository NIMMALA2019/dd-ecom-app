package com.ntreddy.dd.ecommerce.dao.impl.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ntreddy.dd.ecommerce.dao.order.OrderItemDao;
import com.ntreddy.dd.ecommerce.entity.OrderItem;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {

	@Override
	public Page<OrderItem> findByOrder_Id(Long orderId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderItem save(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItem findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
