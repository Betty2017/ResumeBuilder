package com.resume.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.resume.dao.IPersonDAO;
import com.resume.dao.IPhotoDAO;
import com.resume.model.Person;
import com.resume.model.Photo;


@Component
public class PersonService implements IPersonService {
	
	@Autowired
	IPersonDAO personDAO;
	
	@Autowired
	IPhotoDAO photoDAO;
	
	
	
	@Override
	public boolean savePerson(Person person)  throws Exception{
		
		personDAO.savePerson(person);
		return false;
		
		
	}
	
	@Override
	public Iterable<Person> fetchAll()throws Exception {
		return personDAO.fetchAll();
			 
		
	}
		
	
	
	
	/* (non-Javadoc)
	 * @see com.resume.service.IPersonService#fetchPersons(java.lang.String)
	 */
	@Override
	public List<Person> fetchPersons(String searchTerm){
		//stub out a person fetch mechanism.
		List<Person> matchingPerson = new ArrayList<Person>();
		if(searchTerm.contains("eti")|| searchTerm.contains("ini")) {
			Person person = new Person();
			person.setfName("Beti");
			person.setlName("Negati");
			person.setpNumber("577 777 7777");
			person.setEmail("beti@gmail.com");
			matchingPerson.add(person);
		}
		
		return matchingPerson;
		
		
	}

	@Override
	public void saveImage(MultipartFile imageFile,Photo photo) throws Exception {
		photoDAO.saveImage(photo, imageFile);
		photoDAO.save(photo);
		
	}

}
