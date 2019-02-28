package com.resume.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.resume.model.Person;
import com.resume.repository.PersonRepository;

@Component
public class PersonDAO implements IPersonDAO {
	
	@Autowired
	PersonRepository personRepo;
	
	
	/* (non-Javadoc)
	 * @see com.resume.dao.IPersonDAO#savePerson(com.resume.model.Person)
	 */
	@Override
	public boolean savePerson(Person person) throws Exception {
		 personRepo.save(person);
		return false;
	}
	
	@Override
	public Iterable<Person> fetchAll() throws Exception {
		return personRepo.findAll();
	}

	

}
