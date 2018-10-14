package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.spring.dao.EmpJpaDaoImpl;
@Configuration
@ComponentScan(basePackages="com.demo.spring")
//@ImportResource("classpath:cotext.xml") // this is for importing the another project into here thts have contxt.xml
public class AppConfiguration {

	@Bean
	public EmpJpaDaoImpl jpaDao() {
		 return new EmpJpaDaoImpl();
	}
	
	/*@Bean
	public EmpDaoImpl dao() {
		 return new EmpDaoImpl();
	}*/
}
