package com.ntreddy.dd.ecommerce.exception;

import lombok.Data;

@Data
public class AlreadyExistException extends RuntimeException {
    private String message;

    public AlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
