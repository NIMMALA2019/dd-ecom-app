package com.ntreddy.dd.ecommerce.dto.request.cart;


import lombok.Data;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class CartItemRequest {
    @NotNull(message = "Product ID is required")
    private Long productId;
    
    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
    @Max(value = 10_000_000, message = "Quantity must be less than or equal to 10 000 000")
    @NotNull(message = "Quantity is required")
    private Integer quantity;

    @DecimalMin(value = "0.00", message = "Price must be greater than or equal to 0.00")
    @DecimalMax(value = "99999999.99", message =  "Price must be less than or equal to 99 999 999.99")
    @NotNull(message = "Price is required")
    private BigDecimal price;
}