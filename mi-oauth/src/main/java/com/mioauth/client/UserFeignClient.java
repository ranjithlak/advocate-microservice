package com.mioauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mioauth.entity.Advocate;
import com.mioauth.securityConfig.FeignClientConfiguration;

@FeignClient(name = "mi-advocate",configuration = FeignClientConfiguration.class)
public interface UserFeignClient {
	
	@GetMapping("/api/auth/get-username")
	Advocate getUsername(@RequestParam String email);

}
