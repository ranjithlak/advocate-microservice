package com.miadvdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miadvdetails.entity.AdvocateDetails;

public interface AdvocateDetailsRepository extends MongoRepository<AdvocateDetails,String> {

}
