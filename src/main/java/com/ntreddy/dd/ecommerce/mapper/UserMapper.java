package com.ntreddy.dd.ecommerce.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.ntreddy.dd.ecommerce.dto.user.UpdateUserRequest;
import com.ntreddy.dd.ecommerce.dto.user.UserResponse;
import com.ntreddy.dd.ecommerce.entity.User;
import com.ntreddy.dd.ecommerce.exception.InputFieldException;
import com.ntreddy.dd.ecommerce.service.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMapper {

	@Autowired
    private CommonMapper commonMapper;
	@Autowired
    private UserService userService;

    public UserResponse getUserById(Long userId) {
        return commonMapper.convertToResponse(userService.getUserById(userId), UserResponse.class);
    }

    public UserResponse getUserInfo(String email) {
        return commonMapper.convertToResponse(userService.getUserInfo(email), UserResponse.class);
    }

//    public List<PerfumeResponse> getCart(List<Long> perfumesIds) {
//        return commonMapper.convertToResponseList(userService.getCart(perfumesIds), PerfumeResponse.class);
//    }

//    public HeaderResponse<BaseUserResponse> getAllUsers(Pageable pageable) {
//        Page<User> users = userService.getAllUsers(pageable);
//        return commonMapper.getHeaderResponse(users.getContent(), users.getTotalPages(), users.getTotalElements(), BaseUserResponse.class);
//    }

    public UserResponse updateUserInfo(String email, UpdateUserRequest userRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        User user = commonMapper.convertToEntity(userRequest, User.class);
        return commonMapper.convertToResponse(userService.updateUserInfo(email, user), UserResponse.class);
    }
}
