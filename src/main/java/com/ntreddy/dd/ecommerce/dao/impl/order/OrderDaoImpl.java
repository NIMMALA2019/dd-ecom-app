package com.ntreddy.dd.ecommerce.dao.impl.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ntreddy.dd.ecommerce.dao.order.OrderDao;
import com.ntreddy.dd.ecommerce.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Override
	public Order createOrder(Object order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Order> findByCustomerId(Long customerId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
