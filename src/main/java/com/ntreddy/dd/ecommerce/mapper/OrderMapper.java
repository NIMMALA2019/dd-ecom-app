package com.ntreddy.dd.ecommerce.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ntreddy.dd.ecommerce.dto.request.order.OrderRequest;
import com.ntreddy.dd.ecommerce.dto.response.cart.CartItemResponse;
import com.ntreddy.dd.ecommerce.dto.response.order.OrderItemResponse;
import com.ntreddy.dd.ecommerce.dto.response.order.OrderResponse;
import com.ntreddy.dd.ecommerce.entity.Order;
import com.ntreddy.dd.ecommerce.entity.OrderItem;
import com.ntreddy.dd.ecommerce.service.order.OrderItemService;
import com.ntreddy.dd.ecommerce.service.order.OrderService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderMapper {

	@Autowired
    private CommonMapper basicMapper;
	@Autowired
    private OrderService orderService;
	@Autowired
    private OrderItemService orderItemService;

    public OrderResponse create(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderDescription(orderRequest.getOrderDescription());
        order.setOrderStatus(orderRequest.getOrderStatus());
        order.setCustomerId(orderRequest.getCustomer_id());

        for(CartItemResponse cartItem : orderRequest.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setProductId(cartItem.getProductId());
            orderItem.setPrice(cartItem.getPrice());
            order.increaseTotalPrice(cartItem.getPrice());
            order.addItem(orderItemService.create(orderItem));
        }

        return basicMapper.convertTo(orderService.create(order), OrderResponse.class);
    }
    public Page<OrderResponse> getAll(Pageable pageable) {
        return orderService.getAll(pageable).map(order -> basicMapper.convertTo(order, OrderResponse.class));
    }
    public OrderResponse getOrderById(Long id) {
        return basicMapper.convertTo(orderService.getOrderById(id), OrderResponse.class);
    }
    public Page<OrderItemResponse> getOrderItemsByOrder(Long orderId, Pageable pageable) {
        return orderService.getOrderItemsByOrder(orderId, pageable)
                .map(orderItem -> basicMapper.convertTo(orderItem, OrderItemResponse.class));
    }
    public Page<OrderResponse> getOrdersByCustomer(Long customerId, Pageable pageable) {
        return orderService.getOrdersByCustomer(customerId, pageable).map(order -> basicMapper.convertTo(order, OrderResponse.class));
    }
    public OrderResponse updateOrder(Long id, OrderRequest updatedOrder) {
        Order order = basicMapper.convertTo(updatedOrder, Order.class);
        return basicMapper.convertTo(orderService.updateOrder(id, order), OrderResponse.class);
    }
    public void deleteOrder(Long id) {
        orderService.deleteOrder(id);
    }
}
