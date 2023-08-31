package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.MyRepository;

@Service
public class ServiceImpl implements ServiceInterface{

	@Autowired
	MyRepository myRepo;
	
	@Autowired
	EmailService emailService;
	
	
	@Override
	public boolean addStudent(Student std) {
		try {
		emailService.sendMail(std.getEmail(), "Account creation", "<h1>Thanks for choosing us: Username is : "+std.getEmail()+"and Password: "+std.getSname());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		myRepo.save(std);	
		
		
		return true;
	}


	@Override
	public Student getStudentById(long sid) {
				
		return myRepo.findById(sid).get();
	}


	@Override
	public List<Student> viewAllStudents() {
		
		return myRepo.findAll();
	}


	@Override
	public boolean deleteStudentById(long sid) {
		myRepo.deleteById(sid);
		
		return true;
	}


	@Override
	public Student updateStudent(Student std) {
		Student std1=myRepo.getById(std.getSid());
		std1.setCity(std.getCity());
		std1.setEmail(std.getEmail());
		std1.setSname(std.getSname());
		
		Student s=myRepo.save(std1);
		
	
		return s;
	}


	@Override
	public List<Student> viewAllStudentAsc() {
		
		
		
		
		
		return myRepo.findByName();
	}

}
