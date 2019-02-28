package com.resume.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.resume.model.Person;

@Component
public class PersonServiceStub  {
	
	
	
	/* (non-Javadoc)
	 * @see com.resume.service.IPersonService#fetchPersons(java.lang.String)
	 */
	
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

}
