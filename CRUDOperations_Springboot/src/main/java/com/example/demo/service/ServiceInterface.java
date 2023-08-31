package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface ServiceInterface {

	boolean addStudent(Student std);

	Student getStudentById(long sid);

	List<Student> viewAllStudents();

	boolean deleteStudentById(long sid);

	Student updateStudent(Student std);

	
	List<Student> viewAllStudentAsc();

}
