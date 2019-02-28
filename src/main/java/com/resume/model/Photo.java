package com.resume.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Photo {
	@Id
	@GeneratedValue
	private int photoId;
	private String photograper;
	private String path;
	private String file;
	private String comments;
	
	@ManyToOne
	@JoinColumn(name="personId")
	private Person person;
	
	
	public String getPhotograper() {
		return photograper;
	}
	public void setPhotograper(String photograper) {
		this.photograper = photograper;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	

}
