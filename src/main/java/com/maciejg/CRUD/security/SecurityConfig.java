package com.maciejg.CRUD.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().anyRequest().permitAll() //pozwolenie na wejscie dla wszystkich użytkowników
		.and().cors().and().csrf().disable(); //POST nie działa przez SPRING SECURITY tutaj go wyłączam
		
	}
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                        "Access-Control-Request-Headers");
	}
	
}
