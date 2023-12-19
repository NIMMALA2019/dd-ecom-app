package com.ntreddy.dd.ecommerce.exception;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
    private String message;


    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
