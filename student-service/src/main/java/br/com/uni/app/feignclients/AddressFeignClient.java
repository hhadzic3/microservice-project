package br.com.uni.app.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.uni.app.response.AddressResponse;

@FeignClient(value = "api-gateway")
public interface AddressFeignClient {
	
	@GetMapping("address-service/api/address/getById/{id}")
	public AddressResponse getById(@PathVariable Long id);
}
