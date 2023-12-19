package com.ntreddy.dd.ecommerce.dto.request.order;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OrderItemRequest {
    @Min(value = 1, message = "Quantity must be greater than or equal to 1")
    @Max(value = 10_000_000, message = "Quantity must be less than or equal to 10 000 000")
    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @NotNull(message = "Product ID is required")
    private Long productId;
}