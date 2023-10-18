package com.example.demo.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
//Entity annotation defines that a class can be mapped to a table
@Entity
//@Table annotation defines name of the table
@Table(name = "student")
public class Student {
     
	//Spring Data JPA focuses on using JPA to store data in a relational database
	//JPA's ORM mapping converts object-oriented Java code to the back-end database
	
	//@Id annotation specifies the primary key of an entity
	@Id
	//@GeneratedValue - Provides for the specification of generation strategies for the values of primary keys. 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	@Column(name = "name")
	public String name;
	@Column(name = "age")
	public int age;
	@Column(name= "email")
	public String email;

	
	
    

//Constructor
	public Student(long id, String name, int age, String email) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}




//getters and setters

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

