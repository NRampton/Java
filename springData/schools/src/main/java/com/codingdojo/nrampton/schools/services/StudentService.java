package com.codingdojo.nrampton.schools.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.schools.models.Student;
import com.codingdojo.nrampton.schools.repositories.StudentRepository;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}
	
	public void createStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void deleteAll() {
		studentRepository.deleteAll();
	}
}
