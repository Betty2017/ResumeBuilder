package com.resume.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;

import com.resume.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	
		
	Person findByPersonId(Long personId);

	Person findByPersonId(String name);

	Object save(MultipartFile imageFile);

}
