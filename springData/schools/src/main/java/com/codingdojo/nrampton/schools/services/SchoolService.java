package com.codingdojo.nrampton.schools.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.schools.models.School;
import com.codingdojo.nrampton.schools.models.Student;
import com.codingdojo.nrampton.schools.repositories.SchoolRepository;

@Service
public class SchoolService {

	private SchoolRepository schoolRepository;
	
	public SchoolService(SchoolRepository schoolRepository) {
		this.schoolRepository = schoolRepository;
	}
	
	public void createSchool(School school) {
		schoolRepository.save(school);
	}
	
	public List<School> getAllSchools() {
		return (List<School>) schoolRepository.findAll();
	}
	
	public School getSchoolById(Long id) {
		return schoolRepository.findOne(id);
	}
	
	public void theNuclearOption() {
		schoolRepository.deleteAll();
	}
	
	public List<Student> getStudentsBySchool(Long id) {
		return schoolRepository.findStudentsById(id);
	}
}
