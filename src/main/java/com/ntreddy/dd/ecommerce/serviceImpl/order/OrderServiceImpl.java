package com.ntreddy.dd.ecommerce.serviceImpl.order;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ntreddy.dd.ecommerce.dao.order.OrderDao;
import com.ntreddy.dd.ecommerce.dao.order.OrderItemDao;
import com.ntreddy.dd.ecommerce.entity.Order;
import com.ntreddy.dd.ecommerce.entity.OrderItem;
import com.ntreddy.dd.ecommerce.service.order.OrderService;
import com.ntreddy.dd.ecommerce.util.UpdatingUtil;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

	@Autowired
    private OrderDao orderDao;
	@Autowired
    private OrderItemDao orderItemDao;

    @Override
    public Order create(Order order) {
        return orderDao.createOrder(order);
    }

    @Override
    public Page<Order> getAll(Pageable pageable) {
        return orderDao.findAll(pageable);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDao.findById(id);
    }

    @Override
    public Page<OrderItem> getOrderItemsByOrder(Long orderId, Pageable pageable) {
        return orderItemDao.findByOrder_Id(orderId, pageable);
    }

    @Override
    public Page<Order> getOrdersByCustomer(Long customerId, Pageable pageable) {
        return orderDao.findByCustomerId(customerId, pageable);
    }

    @Override
    public Order updateOrder(Long id, Order updatedOrder) {
        Order order = getOrderById(id);
        BeanUtils.copyProperties(updatedOrder, order, UpdatingUtil.getNullPropertyNames(order));
        return orderDao.createOrder(order);
    }

    @Override
    public void deleteOrder(Long id) {
    	orderDao.deleteById(id);
    }
}
