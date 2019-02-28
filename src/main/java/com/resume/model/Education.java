package com.resume.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Education {
	
	@Id
	@GeneratedValue
	private long educationId;
	private String majerName;
	private String typeOfDegree;
	private String institutionName;
	private String startYear;
	private String endYear;
	private long personId;
	

	@ManyToOne
	private Person person;

	
	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	
	public long getEducationId() {
		return educationId;
	}

	public void setEducationId(long educationId) {
		this.educationId = educationId;
	}

	public String getMajerName() {
		return majerName;
	}

	public void setMajerName(String majerName) {
		this.majerName = majerName;
	}

	public String getTypeOfDegree() {
		return typeOfDegree;
	}

	public void setTypeOfDegree(String typeOfDegree) {
		this.typeOfDegree = typeOfDegree;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getStartYear() {
		return startYear;
	}

	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
	
	

}
