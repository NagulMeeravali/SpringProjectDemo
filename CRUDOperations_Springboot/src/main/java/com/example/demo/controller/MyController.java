package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

import com.example.demo.service.ServiceInterface;
@CrossOrigin
@RestController
public class MyController {

	@Autowired
	ServiceInterface serviceInterface;
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student std) {
		String str=null;
		
		boolean b=serviceInterface.addStudent(std);
		if(b) {
			str="Student record added successfully";
		}
		else {
			str="failed in adding student record";
		}
		
		return str;
	}
	
	@PostMapping("/getStudentById/{sid}")
	public Student getStudentById(@PathVariable("sid") int sid) {
		
			
		return serviceInterface.getStudentById(sid);
	}
	@GetMapping("/viewAllStudents")
	public List<Student> viewAllStudents(){
		
		
	  
		return serviceInterface.viewAllStudents();
	}
	
	@DeleteMapping("/deleteById")
	public String deleteStudentById(@RequestBody  Student std) {
		String str=null;
		boolean b=serviceInterface.deleteStudentById(std.getSid());
		if(b) {
			str="Student record deleted successfully";
		}
		return str;
	}
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student std) {
		Student std1=serviceInterface.updateStudent(std);
		
		return std1;
	}
	
	@GetMapping("/viewAllStudentsAsc")
	public List<Student> viewAllStudentsASC(){
		
		return serviceInterface.viewAllStudentAsc();
	}
	
	
	
	
}
