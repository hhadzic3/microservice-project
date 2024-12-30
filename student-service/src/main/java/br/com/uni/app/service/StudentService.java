package br.com.uni.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uni.app.entity.Student;
import br.com.uni.app.repository.StudentRepository;
import br.com.uni.app.request.CreateStudentRequest;
import br.com.uni.app.response.StudentResponse;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	private Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	/*
	 * @Autowired private WebClient webClient;
	 * 
	 * @Autowired private AddressFeignClient addressFeignClient;
	 */
	
	@Autowired
	private CommonService commonService;
	
	public StudentResponse createStudent(CreateStudentRequest csr) {
		logger.info("Request to createStudent received!");
		
		Student student = new Student();
		student.setFirstName(csr.getFirstName());
		student.setLastName(csr.getLastName());
		student.setEmail(csr.getEmail());
		student.setAddressId(csr.getAddressId());

		StudentResponse studentResponse = new StudentResponse(student);
		
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		
		/*
		 * studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		 */
		
		return studentResponse;
	}

	public StudentResponse getById (Long id) {
		logger.info("Request to getById received! Id: "+id);
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student); 
		
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		
		/*
		 * studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		 */
		
		return studentResponse;
	}
	
	// addressService from -> application.properties -> resilience4j.circuitbreaker.instances.addressService...
	/*
	 * @CircuitBreaker(name="addressService", fallbackMethod =
	 * "fallbackGetAddressById") public AddressResponse getAddressById(Long
	 * addressId) { AddressResponse addressResponse =
	 * addressFeignClient.getById(addressId);
	 * 
	 * return addressResponse; }
	 * 
	 * 
	 * public AddressResponse fallbackGetAddressById(Long addressId, Throwable th) {
	 * return new AddressResponse(); }
	 */
}
