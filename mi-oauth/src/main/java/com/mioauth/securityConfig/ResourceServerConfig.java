//package com.mioauth.securityConfig;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
//
//	private static final String RESOURCE_ID = "resource-server-rest-api";
//    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
//    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
//    private static final String SECURED_PATTERN = "/secured/**";
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) {
//        resources.resourceId(RESOURCE_ID);
//    }
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//    	http.formLogin().loginProcessingUrl("/login").loginPage("/login.html").usernameParameter("email").and()
//		.csrf().disable().authorizeRequests().antMatchers("/api/auth/staff/**").permitAll()
//		.antMatchers("*.html").permitAll().anyRequest()
//		.authenticated().and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler())
//		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//}

