package com.ntreddy.dd.ecommerce.controller;

import static com.ntreddy.dd.ecommerce.constants.PathConstants.ACTIVATE_CODE;
import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1_REGISTRATION;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntreddy.dd.ecommerce.dto.request.RegistrationRequest;
import com.ntreddy.dd.ecommerce.mapper.AuthenticationMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_REGISTRATION)
public class RegistrationController {
	
	@Autowired
    private AuthenticationMapper authenticationMapper;

    @PostMapping
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationRequest user, BindingResult bindingResult) {
        return ResponseEntity.ok(authenticationMapper.registerUser(user.getCaptcha(), user, bindingResult));
    }

//    @GetMapping(ACTIVATE_CODE)
//    public ResponseEntity<String> activateEmailCode(@PathVariable String code) {
//        return ResponseEntity.ok(authenticationMapper.activateUser(code));
//    }
}
