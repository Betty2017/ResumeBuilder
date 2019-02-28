package com.resume.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long personId;

	private String fName;

	private String lName;

	private String pNumber;

	private String email;
	
	
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "personId") private List<Education> educations = new
	 * ArrayList<>();
	 */

	/*
	 * @OneToMany(mappedBy="person") private List<Photo> photos;
	 */
	

	public Person() {

	}

	public Person(long personId, String fName, String lName, String pNumber, String email) {
		super();
		this.personId = personId;
		this.fName = fName;
		this.lName = lName;
		this.pNumber = pNumber;
		this.email = email;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getpNumber() {
		return pNumber;
	}

	public void setpNumber(String pNumber) {
		this.pNumber = pNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", fName=" + fName + ", lName=" + lName + ", pNumber=" + pNumber
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + ((pNumber == null) ? 0 : pNumber.hashCode());
		result = prime * result + (int) (personId ^ (personId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (pNumber == null) {
			if (other.pNumber != null)
				return false;
		} else if (!pNumber.equals(other.pNumber))
			return false;
		if (personId != other.personId)
			return false;
		return true;
	}

}
