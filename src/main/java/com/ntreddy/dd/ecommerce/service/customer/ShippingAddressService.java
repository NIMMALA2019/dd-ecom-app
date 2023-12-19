package com.ntreddy.dd.ecommerce.service.customer;


import java.util.List;

import com.ntreddy.dd.ecommerce.entity.ShippingAddress;

public interface ShippingAddressService {
    ShippingAddress createShippingAddress(Long customerId, ShippingAddress address);
    ShippingAddress getShippingAddressById(Long id);
    List<ShippingAddress> getAllShippingAddressesByCustomerId(Long customerId);
    ShippingAddress updateShippingAddress(Long id, ShippingAddress addressDetails);
    void deleteShippingAddress(Long id);
}
