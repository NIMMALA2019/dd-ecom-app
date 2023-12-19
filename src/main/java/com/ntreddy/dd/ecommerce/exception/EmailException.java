package com.ntreddy.dd.ecommerce.exception;

import lombok.Getter;

@Getter
public class EmailException extends RuntimeException {
    private final String emailError;

    public EmailException(String emailError) {
        this.emailError = emailError;
    }

	public String getEmailError() {
		return emailError;
	}
    
    
}
