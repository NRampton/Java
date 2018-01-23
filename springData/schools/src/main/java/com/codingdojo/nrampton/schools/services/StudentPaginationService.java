package com.codingdojo.nrampton.schools.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.codingdojo.nrampton.schools.repositories.StudentPaginationRepository;

@Service
@Transactional
public class StudentPaginationService {
	@Autowired
	StudentPaginationRepository _spr;
	private static final int PAGE_SIZE = 5;
	public Page<Object[]> studentsPerPage(int pageNumber) {
		Pageable pageRequest = new Pageable(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "name");
		Page<Object[]> students = _spr.getStudentsAndSchools(pageRequest);
		return students;
	}
	
}
