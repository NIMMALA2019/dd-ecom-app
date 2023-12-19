package com.ntreddy.dd.ecommerce.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.ntreddy.dd.ecommerce.dto.request.customer.WishlistRequest;
import com.ntreddy.dd.ecommerce.dto.response.customer.WishlistResponse;
import com.ntreddy.dd.ecommerce.service.customer.WishlistService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WishlistMapper {

	@Autowired
    private CommonMapper basicMapper;
	@Autowired
    private WishlistService wishlistService;

    public WishlistResponse create(WishlistRequest wishlistRequest) {
        return basicMapper.convertTo(wishlistService.create(wishlistRequest), WishlistResponse.class);
    }

    public Page<WishlistResponse> getAllByCustomerId(Long customerId, Pageable pageable) {
        return wishlistService.getAllByCustomerId(customerId, pageable).map(w -> basicMapper.convertTo(w, WishlistResponse.class));
    }

    public void deleteById(Long id) {
        wishlistService.delete(id);
    }
}
