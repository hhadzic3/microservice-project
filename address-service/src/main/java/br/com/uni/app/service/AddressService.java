package br.com.uni.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uni.app.entity.Address;
import br.com.uni.app.repository.AddressRepository;
import br.com.uni.app.request.CreateAddressRequest;
import br.com.uni.app.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	private Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	
	public AddressResponse getById(Long id) {
		logger.info("Request to 'getById' received! Id: "+id);
		return new AddressResponse(addressRepository.findById(id).get());
	}
	
	public AddressResponse create(CreateAddressRequest createAddressRequest) {
		logger.info("Request to 'create' received!");
		Address address = new Address();
		address.setCity(createAddressRequest.getCity());
		address.setStreet(createAddressRequest.getStreet());
		return new AddressResponse(address);
	}
		
}
