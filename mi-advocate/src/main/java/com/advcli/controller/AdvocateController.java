package com.advcli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advcli.dto.AdvocateForm;
import com.advcli.entity.Advocate;
import com.advcli.repository.AdvocateRepository;

@RestController
@RequestMapping("/api/auth")
public class AdvocateController {
	
	@Autowired(required=false)
	private AdvocateRepository advocateRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@PostMapping("/advocate")
	public ResponseEntity<?>  createAdvocate(@RequestBody AdvocateForm advocateForm ){
	     ResponseEntity<?> responseMessage = null;
		try {
			System.out.println(advocateForm.getName()+" "+advocateForm.getPassword()+" "+advocateForm.getEmail()+" "+advocateForm.getCity());
			System.out.println(encoder.encode("abc"));
			Advocate ad = new Advocate(advocateForm.getName(),encoder.encode(advocateForm.getPassword()),advocateForm.getEmail(),
					advocateForm.getCity());
			advocateRepository.save(ad);
			String message="advocate create sucessfully";
			responseMessage = new ResponseEntity<>(message,
					HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
		} 
		return responseMessage;
		
	}
	
	@GetMapping("/get-details")
	public ResponseEntity<List<Advocate>> getDetails(){
		List<Advocate> responseMessage = null;
		try {
		   responseMessage = advocateRepository.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		 return new ResponseEntity<>(responseMessage,
				HttpStatus.OK);
	}
	
	@GetMapping("/get-username")
	public Advocate getUsername(String email) {
		List<Advocate> user = null;
		Advocate advocate=null;
		try {
			user = advocateRepository.findByEmail(email);
			if(user.size()>0)
			 advocate=user.stream().findFirst().get();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return advocate;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
