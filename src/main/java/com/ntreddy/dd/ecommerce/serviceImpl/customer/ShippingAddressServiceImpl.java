package com.ntreddy.dd.ecommerce.serviceImpl.customer;




import java.util.List;

import org.springframework.stereotype.Service;

import com.ntreddy.dd.ecommerce.entity.ShippingAddress;
import com.ntreddy.dd.ecommerce.service.customer.ShippingAddressService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShippingAddressServiceImpl implements ShippingAddressService {

	@Override
	public ShippingAddress createShippingAddress(Long customerId, ShippingAddress address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShippingAddress getShippingAddressById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShippingAddress> getAllShippingAddressesByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShippingAddress updateShippingAddress(Long id, ShippingAddress addressDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteShippingAddress(Long id) {
		// TODO Auto-generated method stub
		
	}

//    private final ShippingAddressServiceRepository shippingAddressServiceRepository;
//    private final CustomerServiceImpl customerService;
//
//    @Override
//    public ShippingAddress createShippingAddress(Long customerId, ShippingAddress address) {
//        Customer customer = customerService.getById(customerId);
//        address.setCustomer(customer);
//        return shippingAddressServiceRepository.save(address);
//    }
//
//    @Override
//    public ShippingAddress getShippingAddressById(Long id) {
//        return shippingAddressServiceRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("Shipping address not found"));
//    }
//
//    @Override
//    public List<ShippingAddress> getAllShippingAddressesByCustomerId(Long customerId) {
//        return shippingAddressServiceRepository.findAllByCustomer_Id(customerId);
//    }
//
//    @Override
//    public ShippingAddress updateShippingAddress(Long id, ShippingAddress addressDetails) {
//        ShippingAddress address = getShippingAddressById(id);
//        BeanUtils.copyProperties(addressDetails, address, UpdatingUtil.getNullPropertyNames(addressDetails));
//        return shippingAddressServiceRepository.save(address);
//    }
//
//    @Override
//    public void deleteShippingAddress(Long id) {
//        shippingAddressServiceRepository.deleteById(id);
//    }
}
