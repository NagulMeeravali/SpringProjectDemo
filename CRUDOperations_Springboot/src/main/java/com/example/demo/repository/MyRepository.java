package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface MyRepository extends JpaRepository<Student, Long> {

	@Query(value="select * from Student order by sname",nativeQuery = true)
	List<Student> findByName();
}
