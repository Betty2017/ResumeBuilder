package com.resume.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long jobId;
	private String jobTitle;
	private String companyName;
	private String startDate;
	private String endDate;
	private Long personId;
	
	
	
	public Experiance() {
		
	}
	
	
	
	public Experiance(Long jobId, String jobTitle, String companyName, String startDate, String endDate,
			Long personId) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.companyName = companyName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.personId = personId;
	}



	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

}
