package com.advcli;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
@EnableEurekaClient
public class MiAdvocateApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(MiAdvocateApplication.class, args);
	}

}
