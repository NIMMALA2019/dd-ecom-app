package com.ntreddy.dd.ecommerce.service.order;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntreddy.dd.ecommerce.entity.Order;
import com.ntreddy.dd.ecommerce.entity.OrderItem;

public interface OrderService {
    Order create(Order order);
    Page<Order> getAll(Pageable pageable);
    Order getOrderById(Long id);
    Page<OrderItem> getOrderItemsByOrder(Long orderId, Pageable pageable);
    Page<Order> getOrdersByCustomer(Long customerId, Pageable pageable);
    Order updateOrder(Long orderId, Order updatedOrder);
    void deleteOrder(Long id);
}
