package com.mioauth.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mioauth.client.UserFeignClient;
import com.mioauth.entity.Advocate;
import com.mioauth.entity.AuthenticatedUser;


@Service
public class UserDetailsServiceImpl implements UserDetailsService,UserService {
	
	@Autowired
	private UserFeignClient userClient;

//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Advocate user = userClient.getUsername(email);
//		System.out.println("######################"+user.getEmail());
//		if (user != null) {
//			System.out.println("???"+user.getEmail());
//			return AuthenticatedUser.build(user);
//		} else {
//            throw new UsernameNotFoundException(String.format("User not found for a given email address =%s", email));
//		}
//	}
	
	
	@Override
	public UserDetails loadUserByUsername(String email)
			 throws UsernameNotFoundException {

		Advocate user = userClient.getUsername(email);

		if (user == null) {
			throw new UsernameNotFoundException(
					"Error en el login, no existe el usuario " 
			+ email + " en el sistema");
		}
		List<GrantedAuthority> authorities = 
				new ArrayList<>();

	
		System.out.println("######################"+user.getEmail());
		
		System.out.println(user.getEmail()+ user.getPassword()+
				true+ true+ true+ authorities);
		return new User(user.getEmail(), user.getPassword(), 
				true, true, true, true,authorities );
		
	}
	
	

	@Override
	public Advocate getUsername(String email) {
		return userClient.getUsername(email);
	}


}
