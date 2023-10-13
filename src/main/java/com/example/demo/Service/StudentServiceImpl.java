package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;


@Service
public class StudentServiceImpl {
	
	public StudentRepository repo;
	
	
	public StudentServiceImpl(StudentRepository repo) {
		
		this.repo = repo;
	}


	public List<Student> getStudents() {
		return repo.findAll();
	}
	
	public Student create(Student student) {
    	return repo.save(student);
    }
	
	
	public  Student getStudentById(long id ) {
		Student student = repo.findById(id).orElseThrow(null);
			return student;
	}
	
	public Student update(Student student, long id) {
		
		Student existingStudent = repo.findById(id).orElseThrow(null);
		
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setEmail(student.getEmail());
	    repo.save(existingStudent);
	    return existingStudent;
	}
    
  
	
	public void delete( long id) {
		repo.deleteById(id);
	}






	

}
