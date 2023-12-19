package com.ntreddy.dd.ecommerce.exception;

import lombok.Getter;

@Getter
public class CaptchaException extends RuntimeException {
    private final String captchaError;

    public CaptchaException(String captchaError) {
        this.captchaError = captchaError;
    }

	public String getCaptchaError() {
		return captchaError;
	}
    
    
}
