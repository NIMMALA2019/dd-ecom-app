package com.ntreddy.dd.ecommerce.security.oauth2;

import lombok.RequiredArgsConstructor;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.ntreddy.dd.ecommerce.entity.User;
import com.ntreddy.dd.ecommerce.security.UserPrincipal;
import com.ntreddy.dd.ecommerce.service.AuthenticationService;
import com.ntreddy.dd.ecommerce.service.UserService;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

	@Autowired
    @Lazy private AuthenticationService authenticationService;
    @Autowired
	private UserService userService;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String provider = userRequest.getClientRegistration().getRegistrationId();
        OAuth2User oAuth2User = super.loadUser(userRequest);
        OAuth2UserInfo oAuth2UserInfo = null;
		
        User user = userService.getUserInfo(oAuth2UserInfo.getEmail());

//        if (user == null) {
//            user = authenticationService.registerOauth2User(provider, oAuth2UserInfo);
//        } else {
//            user = authenticationService.updateOauth2User(user, provider, oAuth2UserInfo);
//        }
        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }
}
