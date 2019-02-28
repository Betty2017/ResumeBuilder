package com.resume.dao;

import org.springframework.web.multipart.MultipartFile;

import com.resume.model.Person;

public interface IPersonDAO {

	boolean savePerson(Person person) throws Exception;

	Iterable<Person> fetchAll() throws Exception;

	

	

}