package com.ntreddy.dd.ecommerce.mapper;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ntreddy.dd.ecommerce.dto.request.customer.ShippingAddressRequest;
import com.ntreddy.dd.ecommerce.dto.response.customer.ShippingAddressResponse;
import com.ntreddy.dd.ecommerce.entity.ShippingAddress;
import com.ntreddy.dd.ecommerce.service.customer.ShippingAddressService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ShippingAddressMapper {

	@Autowired
    private CommonMapper basicMapper;
	@Autowired
    private ShippingAddressService shippingAddressService;

    public ShippingAddressResponse createShippingAddress(ShippingAddressRequest address) {
        ShippingAddress shippingAddress = basicMapper.convertTo(address, ShippingAddress.class);
        return basicMapper.convertTo(
                shippingAddressService.createShippingAddress(address.getCustomerId(), shippingAddress),
                ShippingAddressResponse.class
        );
    }

    public ShippingAddressResponse getShippingAddressById(Long id) {
        return basicMapper.convertTo(shippingAddressService.getShippingAddressById(id), ShippingAddressResponse.class);
    }

    public List<ShippingAddressResponse> getAllShippingAddressesByCustomerId(Long customerId) {
        return basicMapper.convertListTo(shippingAddressService.getAllShippingAddressesByCustomerId(customerId), ShippingAddressResponse.class);
    }

    public ShippingAddressResponse updateShippingAddress(Long id, ShippingAddressRequest addressDetails) {
        ShippingAddress shippingAddress = basicMapper.convertTo(addressDetails, ShippingAddress.class);
        return basicMapper.convertTo(shippingAddressService.updateShippingAddress(id, shippingAddress), ShippingAddressResponse.class);
    }

    public void deleteShippingAddress(Long id) {
        shippingAddressService.deleteShippingAddress(id);
    }
}
