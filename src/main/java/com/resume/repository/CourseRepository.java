package com.resume.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resume.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long>{
}
