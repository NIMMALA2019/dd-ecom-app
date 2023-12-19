package com.ntreddy.dd.ecommerce.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//import com.ntreddy.dd.ecommerce.dto.PasswordResetRequest;
import com.ntreddy.dd.ecommerce.dto.request.AuthenticationRequest;
import com.ntreddy.dd.ecommerce.dto.response.AuthenticationResponse;
import com.ntreddy.dd.ecommerce.mapper.AuthenticationMapper;
import com.ntreddy.dd.ecommerce.security.UserPrincipal;

import static com.ntreddy.dd.ecommerce.constants.PathConstants.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_V1_AUTH)
public class AuthenticationController {

	@Autowired
    private AuthenticationMapper authenticationMapper;

    @PostMapping(LOGIN)
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationMapper.login(request));
    }

//    @GetMapping(FORGOT_EMAIL)
//    public ResponseEntity<String> forgotPassword(@PathVariable String email) {
//        return ResponseEntity.ok(authenticationMapper.sendPasswordResetCode(email));
//    }
//
//    @GetMapping(RESET_CODE)
//    public ResponseEntity<String> getEmailByPasswordResetCode(@PathVariable String code) {
//        return ResponseEntity.ok(authenticationMapper.getEmailByPasswordResetCode(code));
//    }
//
//    @PostMapping(RESET)
//    public ResponseEntity<String> passwordReset(@RequestBody PasswordResetRequest passwordReset) {
//        return ResponseEntity.ok(authenticationMapper.passwordReset(passwordReset.getEmail(), passwordReset));
//    }
//
//    @PutMapping(EDIT_PASSWORD)
//    public ResponseEntity<String> updateUserPassword(@AuthenticationPrincipal UserPrincipal user,
//                                                     @Valid @RequestBody PasswordResetRequest passwordReset,
//                                                     BindingResult bindingResult) {
//        return ResponseEntity.ok(authenticationMapper.passwordReset(user.getEmail(), passwordReset, bindingResult));
//    }
}
