package com.ntreddy.dd.ecommerce.mapper;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ntreddy.dd.ecommerce.service.order.OrderItemService;

@Component
@RequiredArgsConstructor
public class OrderItemMapper {

	@Autowired
    private OrderItemService orderItemService;

    public void deleteOrderItem(Long id) {
        orderItemService.deleteOrderItem(id);
    }
}
