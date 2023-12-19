package com.ntreddy.dd.ecommerce.dto.request.order;


import javax.validation.constraints.Size;

import com.ntreddy.dd.ecommerce.dto.response.cart.CartResponse;
import com.ntreddy.dd.ecommerce.enums.OrderStatus;

import lombok.Data;

@Data
public class OrderRequest extends CartResponse {
    @Size(min = 3, max = 25, message = "Order description must be between 3 and 100 characters")
    private String orderDescription;
    private OrderStatus orderStatus;
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
    
    
    
    
    
}
