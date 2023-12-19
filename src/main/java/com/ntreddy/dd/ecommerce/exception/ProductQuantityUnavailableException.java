package com.ntreddy.dd.ecommerce.exception;

import lombok.Data;

@Data
public class ProductQuantityUnavailableException extends RuntimeException {
    private String message;

    public ProductQuantityUnavailableException(String message) {
        super(message);
        this.message = message;
    }
}
