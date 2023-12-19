package com.ntreddy.dd.ecommerce.mapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ntreddy.dd.ecommerce.dto.response.customer.CustomerResponse;
import com.ntreddy.dd.ecommerce.service.customer.CustomerService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

	@Autowired
    private CommonMapper basicMapper;
	@Autowired
    private CustomerService customerService;

//    public CustomerResponse registration(CustomerRequest customerRequest) {
//        Customer customer = basicMapper.convertTo(customerRequest, Customer.class);
//        return basicMapper.convertTo(customerService.registration(customer), CustomerResponse.class);
//    }

    public CustomerResponse uploadImage(MultipartFile image, Long customerId) {
        return basicMapper.convertTo(customerService.uploadImage(image, customerId), CustomerResponse.class);
    }

    public Page<CustomerResponse> getAll(Pageable pageable) {
        return customerService.getAll(pageable).map(customer -> basicMapper.convertTo(customer, CustomerResponse.class));
    }
    public CustomerResponse getById(Long id) {
        return basicMapper.convertTo(customerService.getById(id), CustomerResponse.class);
    }
    public CustomerResponse getByUsername(String username) {
        return basicMapper.convertTo(customerService.getByUsername(username), CustomerResponse.class);
    }
    public void deleteById(Long id) {
        customerService.deleteById(id);
    }
}
