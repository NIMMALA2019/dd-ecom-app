package com.ntreddy.dd.ecommerce.service.order;

import com.ntreddy.dd.ecommerce.entity.OrderItem;

public interface OrderItemService {
    OrderItem create(OrderItem orderItem);
    OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem);
    void deleteOrderItem(Long id);
}