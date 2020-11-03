package com.advcli.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.advcli.entity.Advocate;


public interface AdvocateRepository extends MongoRepository<Advocate,String> {
	
   List<Advocate> findByEmail(String email);

	
}
