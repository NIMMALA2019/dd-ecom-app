package com.ntreddy.dd.ecommerce.exception;

import lombok.Getter;

@Getter
public class CategoryLevelException extends RuntimeException {
    private String message;

    public CategoryLevelException(String message) {
        super(message);
        this.message = message;
    }
}
