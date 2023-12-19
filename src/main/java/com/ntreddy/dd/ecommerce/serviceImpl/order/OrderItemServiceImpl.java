package com.ntreddy.dd.ecommerce.serviceImpl.order;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntreddy.dd.ecommerce.dao.catalog.ProductDao;
import com.ntreddy.dd.ecommerce.dao.order.OrderItemDao;
import com.ntreddy.dd.ecommerce.entity.OrderItem;
import com.ntreddy.dd.ecommerce.service.order.OrderItemService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
    private OrderItemDao orderItemDao;
	@Autowired
    private ProductDao productClient;

    private void increaseOrderCount(Long productId) {
        productClient.updateOrdersCount(productId, true);
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        increaseOrderCount(orderItem.getProductId());
        return orderItemDao.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem) {
        OrderItem orderItem = orderItemDao.findById(id);
        orderItem.setQuantity(updatedOrderItem.getQuantity());
        orderItem.setOrder(updatedOrderItem.getOrder());
        orderItem.setProductId(updatedOrderItem.getProductId());
        if(!Objects.equals(orderItem.getProductId(), updatedOrderItem.getProductId())) {
            increaseOrderCount(updatedOrderItem.getProductId());
        }
        return orderItemDao.save(orderItem);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemDao.deleteById(id);
    }
}