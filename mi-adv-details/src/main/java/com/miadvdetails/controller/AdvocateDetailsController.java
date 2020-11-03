package com.miadvdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.miadvdetails.entity.AdvocateDetails;
import com.miadvdetails.form.AdvocateDetailsForm;
import com.miadvdetails.repository.AdvocateDetailsRepository;

@RestController
@RequestMapping("/auth")
public class AdvocateDetailsController {
	
	@Autowired(required=false)
	private AdvocateDetailsRepository advocateDetailsRepository;
	
	@PostMapping("/advocate-details")
	public ResponseEntity<?>  createAdvocate(@RequestBody AdvocateDetailsForm advocateDetailsForm ){
	     ResponseEntity<?> responseMessage = null;
	     try {
	      AdvocateDetails advocateDetails = new AdvocateDetails(advocateDetailsForm.getLanguage(),
	    		  advocateDetailsForm.getArea(),advocateDetailsForm.getDescription());
	      advocateDetailsRepository.save(advocateDetails);
	      String message="saved sucessfully";
	      responseMessage = new ResponseEntity<>(message,
					HttpStatus.OK);
		}catch(Exception e) {
	    	e.printStackTrace(); 
	     }
	     return responseMessage;
	}
	
	@GetMapping("/advocate-get-details")
	public ResponseEntity<List<AdvocateDetails>> getAdvocateDetails(){
		List<AdvocateDetails> responseMessage = null;
		try {
			responseMessage = advocateDetailsRepository.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		 return new ResponseEntity<>(responseMessage,
					HttpStatus.OK);
	}

}
