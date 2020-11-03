package com.mioauth.securityConfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.mioauth.entity.Advocate;
import com.mioauth.service.UserService;

public class CustomTokenEnhancer1 implements TokenEnhancer {
	
	@Autowired
	private UserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		
		UserDetails user = (UserDetails)authentication.getPrincipal();
		if(user!=null) {
		    System.out.println("********"+user.toString());

		Advocate user1 =userService.getUsername(user.getUsername());
		info.put("email", user1.getEmail());
		}else {
		    System.out.println("********user is null");

		}
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}
}
