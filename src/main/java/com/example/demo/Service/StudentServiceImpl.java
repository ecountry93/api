package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;

// @Service annotation is used with classes
//that provide some business functionalities or business logic
@Service
public class StudentServiceImpl {
	
	//dependency injection
	public StudentRepository repo;
	
	
	public StudentServiceImpl(StudentRepository repo) {
		
		this.repo = repo;
	}
        // fetches all the files from the database
	public List<Student> getStudents() {
		return repo.findAll();
	}
	//create operation
	public Student create(Student student) {
    	return repo.save(student);
    }
	
	//read operation
	public  Student getStudentById(long id ) {
		Student student = repo.findById(id).orElseThrow(null);
			return student;
	}
	//update operation
	public Student update(Student student, long id) {
		
		Student existingStudent = repo.findById(id).orElseThrow(null);
		
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setEmail(student.getEmail());
	    repo.save(existingStudent);
	    return existingStudent;
	}
    
  
	//delete operation
	public void delete( long id) {
		repo.deleteById(id);
	}






	

}
