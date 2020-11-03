package com.mioauth.service;

import com.mioauth.entity.Advocate;

public interface UserService {
	public Advocate getUsername(String email);
}