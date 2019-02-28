package com.resume.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.resume.model.Person;
import com.resume.model.Photo;

public interface IPersonService {

	boolean savePerson(Person person) throws Exception;

	List<Person> fetchPersons(String searchTerm);

	Iterable<Person> fetchAll() throws Exception;

	void saveImage(MultipartFile imageFile,Photo photo) throws Exception;

}