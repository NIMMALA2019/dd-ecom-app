package com.ntreddy.dd.ecommerce.serviceImpl.customer;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ntreddy.dd.ecommerce.dto.request.customer.WishlistRequest;
import com.ntreddy.dd.ecommerce.entity.Wishlist;
import com.ntreddy.dd.ecommerce.service.customer.WishlistService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

	@Override
	public Wishlist create(WishlistRequest wishlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Wishlist> getAllByCustomerId(Long id, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

//    private final WishlistRepository wishlistRepository;
//    private final CustomerService customerService;
//    private final ProductClient productClient;
//
//    @Override
//    public Wishlist create(WishlistRequest wishlistRequest) {
//        Wishlist wishlist = new Wishlist();
//        Customer customer = customerService.getById(wishlistRequest.getCustomerId());
//        Long productId = productClient.getProductById(wishlistRequest.getProductId()).getBody().getId();;
//        wishlist.setCustomer(customer);
//        wishlist.setProductId(productId);
//        return wishlistRepository.save(wishlist);
//    }
//
//    @Override
//    public Page<Wishlist> getAllByCustomerId(Long id, Pageable pageable) {
//        return wishlistRepository.findAllByCustomer_Id(id, pageable);
//    }
//
//    @Override
//    public void delete(Long id) {
//        wishlistRepository.deleteById(id);
//    }
	
}