package br.com.uni.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uni.app.request.CreateAddressRequest;
import br.com.uni.app.response.AddressResponse;
import br.com.uni.app.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	
	@GetMapping("/getById/{id}")
	public AddressResponse getById(@PathVariable Long id) {
		return addressService.getById(id);
	}
	
	
	@PostMapping("/create")
	public AddressResponse create(@RequestBody CreateAddressRequest createAddressRequest) {
		return addressService.create(createAddressRequest);
	}
	
}
