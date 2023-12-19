package com.ntreddy.dd.ecommerce.serviceImpl.customer;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.dto.request.cart.CartRequest;
import com.ntreddy.dd.ecommerce.entity.Customer;
import com.ntreddy.dd.ecommerce.exception.AlreadyExistException;
import com.ntreddy.dd.ecommerce.service.customer.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer uploadImage(MultipartFile image, Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Customer> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

//    private final CustomerRepository customerRepository;
//    private final ImageClient imageClient;
//    private final AuthClient authClient;
//    private final CartClient cartClient;

//    @Override
//    public Customer uploadImage(MultipartFile image, Long customerId) {
//        Customer customer = getById(customerId);
//        if(image != null && !image.isEmpty()) {
//            String imageUrl = imageClient.uploadImage(image);
//            customer.setImageUrl(imageUrl);
//        }
//        return customer;
//    }
//
//    @Override
//    public Page<Customer> getAll(Pageable pageable) {
//        return customerRepository.findAll(pageable);
//    }
//
//    @Override
//    public Customer getById(Long id) {
//        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));
//    }
//
//    @Override
//    public Customer getByUsername(String username) {
//        return customerRepository.findByUsername(username);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        customerRepository.deleteById(id);
//    }
}
