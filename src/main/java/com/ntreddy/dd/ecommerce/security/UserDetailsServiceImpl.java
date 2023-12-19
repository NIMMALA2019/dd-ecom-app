package com.ntreddy.dd.ecommerce.security;

import lombok.RequiredArgsConstructor;

import static com.ntreddy.dd.ecommerce.constants.ErrorMessage.USER_NOT_FOUND;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ntreddy.dd.ecommerce.entity.User;
import com.ntreddy.dd.ecommerce.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
        if (user.getActivationCode() != null) {
            throw new LockedException("Email not activated");
        }
        return UserPrincipal.create(user);
    }
}
