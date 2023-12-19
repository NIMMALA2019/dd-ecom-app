package com.ntreddy.dd.ecommerce.dto.response;

import com.ntreddy.dd.ecommerce.dto.user.UserResponse;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private UserResponse user;
    private String token;
	public UserResponse getUser() {
		return user;
	}
	public void setUser(UserResponse user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
    
}
