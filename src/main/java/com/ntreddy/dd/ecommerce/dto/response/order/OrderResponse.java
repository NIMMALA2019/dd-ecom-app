package com.ntreddy.dd.ecommerce.dto.response.order;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ntreddy.dd.ecommerce.enums.OrderStatus;

import lombok.Data;

@Data
public class OrderResponse {
    private Long id;
    private Long customerId;
    private String orderDescription;
    private BigDecimal orderFee;
    private OrderStatus orderStatus;
    @JsonIgnoreProperties("order")
    private List<OrderItemResponse> orderItems;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
