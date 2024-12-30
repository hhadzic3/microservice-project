package br.com.uni.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uni.app.feignclients.AddressFeignClient;
import br.com.uni.app.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {

	Logger logger = LoggerFactory.getLogger(CommonService.class);
	
	Long count = 1L;
	
	@Autowired
	AddressFeignClient addressFeignClient;
	
	// addressService from -> application.properties -> resilience4j.circuitbreaker.instances.addressService...
		@CircuitBreaker(name="addressService",
				fallbackMethod = "fallbackGetAddressById")
		public AddressResponse getAddressById(Long addressId) {
			logger.info("count = " +count);
			count++;
			AddressResponse addressResponse = 
					addressFeignClient.getById(addressId);
			
			return addressResponse;
		}
		
		
		public AddressResponse fallbackGetAddressById(Long addressId, Throwable th) {
			logger.error("Error = "+th);
			return new AddressResponse();
		}
}
