package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmpDataServiceApplication extends SpringBootServletInitializer{// extends for war outside of embedded server 

	
	public static void main(String[] args) {
		SpringApplication.run(EmpDataServiceApplication.class, args);
	}
	
	// this is for war application outside of any server
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EmpDataServiceApplication.class);
	}
	}
