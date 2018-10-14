package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 // for swagger
public class EmpDataServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EmpDataServiceApplication.class, args);
	}
	
	

// for swagger
	public ApiInfo apiInfo() {
		
		return new ApiInfoBuilder()
				.description("Emp Sping data Rest Apis")
				.license("Open Licence")
				.title("Api Doc for Emp Service")
				.build();
	}
	
	
	// for swagger
	@Bean
	public Docket docket() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.demo.spring"))
				.build()
				.apiInfo(apiInfo());
	
	}
				
	}
