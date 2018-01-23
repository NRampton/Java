package com.codingdojo.nrampton.schools.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.codingdojo.nrampton.schools.models.Student;

public interface StudentPaginationRepository  extends PagingAndSortingRepository<Student, Long> {
	@Query("SELECT sch, stu FROM Student stu JOIN stu.school sch")
	Page<Object[]> getStudentsAndSchools(Pageable pageRequest);
}
