package com.miadvdetails.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "advocate_details")
public class AdvocateDetails {
	
	@Id 
	private String advocateDetailsId;
	
	private String language;
	
	private String area;
	
	private String description;
	
	public AdvocateDetails() {
		
	}
	
	

	public AdvocateDetails(String language, String area, String description) {
		super();
		this.language = language;
		this.area = area;
		this.description = description;
	}



	public String getAdvocateDetailsId() {
		return advocateDetailsId;
	}



	public void setAdvocateDetailsId(String advocateDetailsId) {
		this.advocateDetailsId = advocateDetailsId;
	}



	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}

}
