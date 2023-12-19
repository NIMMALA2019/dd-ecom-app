package com.ntreddy.dd.ecommerce.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse extends BaseUserResponse {
    private String lastName;
    private String city;
    private String address;
    private String phoneNumber;
    private String postIndex;
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPostIndex() {
		return postIndex;
	}
	public void setPostIndex(String postIndex) {
		this.postIndex = postIndex;
	}
    
    
}
