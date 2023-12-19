package com.ntreddy.dd.ecommerce.mapper;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.ntreddy.dd.ecommerce.dto.request.AuthenticationRequest;
//import com.ntreddy.dd.ecommerce.dto.PasswordResetRequest;
import com.ntreddy.dd.ecommerce.dto.request.RegistrationRequest;
import com.ntreddy.dd.ecommerce.dto.response.AuthenticationResponse;
import com.ntreddy.dd.ecommerce.dto.user.UserResponse;
import com.ntreddy.dd.ecommerce.entity.User;
import com.ntreddy.dd.ecommerce.exception.InputFieldException;
//import com.ntreddy.dd.ecommerce.service.AuthenticationService;
import com.ntreddy.dd.ecommerce.service.AuthenticationService;

@Component
public class AuthenticationMapper {

	@Autowired
    private AuthenticationService authenticationService;
	@Autowired
    private CommonMapper commonMapper;

    public AuthenticationResponse login(AuthenticationRequest request) {
    	System.out.println(request.getUsername()+"&&&"+request.getPassword());
    	
        Map<String, Object> credentials = authenticationService.login(request.getUsername(), request.getPassword());
        
        AuthenticationResponse response = new AuthenticationResponse();
        response.setUser(commonMapper.convertToResponse(credentials.get("user"), UserResponse.class));
        response.setToken((String) credentials.get("token"));
        return response;
    }

//    public String getEmailByPasswordResetCode(String code) {
//        return authenticationService.getEmailByPasswordResetCode(code);
//    }

    public String registerUser(String captcha, RegistrationRequest registrationRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        User user = commonMapper.convertToEntity(registrationRequest, User.class);
        return authenticationService.registerUser(user, captcha, registrationRequest.getPassword2());
    }

//    public String activateUser(String code) {
//        return authenticationService.activateUser(code);
//    }
//
//    public String sendPasswordResetCode(String email) {
//        return authenticationService.sendPasswordResetCode(email);
//    }

//    public String passwordReset(String email, PasswordResetRequest passwordReset) {
//        return authenticationService.passwordReset(email, passwordReset.getPassword(), passwordReset.getPassword2());
//    }
//
//    public String passwordReset(String email, PasswordResetRequest passwordReset, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            throw new InputFieldException(bindingResult);
//        } else {
//            return authenticationService.passwordReset(email, passwordReset.getPassword(), passwordReset.getPassword2());
//        }
//    }
}
