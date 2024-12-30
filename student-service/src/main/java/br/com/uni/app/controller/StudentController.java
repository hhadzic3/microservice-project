package br.com.uni.app.controller;
			
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.uni.app.request.CreateStudentRequest;
import br.com.uni.app.response.StudentResponse;
import br.com.uni.app.service.StudentService;
			
@RestController
@RequestMapping("/api/student")
public class StudentController {
			
	@Autowired
	private StudentService studentService;
			
	@GetMapping("/getById/{id}")
	public StudentResponse getById (@PathVariable Long id){
		return studentService.getById(id);
	}
	
	@PostMapping("/create")
	public StudentResponse create (@RequestBody CreateStudentRequest csr) {
		return studentService.createStudent(csr);
	}
}			
			