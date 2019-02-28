package com.resume.repository;

import org.springframework.data.repository.CrudRepository;

import com.resume.model.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
	
	

}
