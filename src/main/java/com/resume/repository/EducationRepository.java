package com.resume.repository;

import org.springframework.data.repository.CrudRepository;

import com.resume.model.Education;

public interface EducationRepository extends CrudRepository <Education, Long> {

	void save(long educ);

}
