package com.ntreddy.dd.ecommerce.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntreddy.dd.ecommerce.dto.request.customer.WishlistRequest;
import com.ntreddy.dd.ecommerce.entity.Wishlist;

public interface WishlistService {
    Wishlist create(WishlistRequest wishlist);
    Page<Wishlist> getAllByCustomerId(Long id, Pageable pageable);
    void delete(Long id);
}
