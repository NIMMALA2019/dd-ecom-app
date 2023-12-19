package com.ntreddy.dd.ecommerce.dto.request.cart;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartRequest {
    @NotNull(message = "Customer ID is required")
    private Long customer_id;

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	
    
}
