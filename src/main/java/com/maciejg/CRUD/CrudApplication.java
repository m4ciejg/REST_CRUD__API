package com.maciejg.CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@EnableJpaAuditing
public class CrudApplication  {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}



