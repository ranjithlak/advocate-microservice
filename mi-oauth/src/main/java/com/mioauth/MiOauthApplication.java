package com.mioauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class MiOauthApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(MiOauthApplication.class, args);
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		System.out.println("inside main **********");
		System.out.println(encoder.encode("secret"));
	}

}
