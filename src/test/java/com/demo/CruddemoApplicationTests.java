package com.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Student;
import com.demo.repositiories.StudentRepository;

@SpringBootTest
class CruddemoApplicationTests {
	
	@Autowired
	private StudentRepository studentRepo; 

	@Test
	void createOneStudent() {
		Student s = new Student();
		s.setName("raman");
		s.setCourse("testing");
		s.setFee(1000);
		studentRepo.save(s);
	}
    
	@Test
	void readOneStudent() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
		
	}
	
	@Test
	void updateOneStudent() {
		Student s = new Student();
		s.setId(1L);
		s.setName("pankaj");
		s.setCourse("java");
		s.setFee(2000);
		studentRepo.save(s);
	}
	
	@Test
	void deleteOneStudent() {
		studentRepo.deleteById(2L);
	}
}
