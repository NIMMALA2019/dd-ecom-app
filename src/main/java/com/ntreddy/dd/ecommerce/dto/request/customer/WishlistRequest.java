package com.ntreddy.dd.ecommerce.dto.request.customer;


import lombok.Data;

@Data
public class WishlistRequest {
    private Long customerId;
    private Long productId;
}
