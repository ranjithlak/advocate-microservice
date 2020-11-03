package com.advcli.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "advocate")
public class Advocate {
	
	@Id 
	private String advocateId;

	private String name;
	
	private String password;
	
	@Indexed(unique=true)
	private String email;
	
	private String city;
	
	public Advocate() {
		
	}
	

	public Advocate(String name, String password, String email, String city) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.city = city;
	}

    

	public String getAdvocateId() {
		return advocateId;
	}


	public void setAdvocateId(String advocateId) {
		this.advocateId = advocateId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Advocate [advocateId=" + advocateId + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", city=" + city + "]";
	}
	
	
	
	

}
