package com.example.demo.Controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentServiceImpl;

@RestController
@RequestMapping("/api/student")
public class StudentController {
		
	
	public StudentServiceImpl service;
	
	
	
	public StudentController(StudentServiceImpl service) {
		this.service = service;
	}
	
	
	@GetMapping()
	public List<Student> getStudents(){
	
		return service.getStudents();	
	}
	
	
	 @PostMapping()
	  public ResponseEntity<Student> create(@RequestBody Student student) {
		return  new ResponseEntity<Student>(service.create(student), HttpStatus.CREATED);
		  
	  }
	 
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentbyId(@PathVariable("id") long id ) {
		return new ResponseEntity<Student>(service.getStudentById(id), HttpStatus.OK);
	}
	
 
  @PutMapping("{id}")
  public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable("id") long id ){
	return new ResponseEntity<Student> (service.update(student, id), HttpStatus.OK);
	  
  } 
	
	@DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") long id) {
	
		service.delete(id);
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
	}
	
	  
	

}
