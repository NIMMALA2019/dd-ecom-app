package com.ntreddy.dd.ecommerce.dto.request.customer;




import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CustomerRequest {
	 @NotNull(message = "Username should be unique and be between 8 and 30 characters")
    private String username;

	@NotNull(message = "Your password must contain at least 8 characters, and include uppercase letters, lowercase letters and numbers.")
    private String password;

    private String role;

    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters")
    private String firstName;

    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters")
    private String lastName;
}