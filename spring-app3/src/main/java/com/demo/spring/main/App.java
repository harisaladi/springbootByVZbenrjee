package com.demo.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.AppConfiguration;
import com.demo.spring.service.HrService;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
		//HrService hr= (HrService)ctx.getBean("hrService"); // this is auto bean name - byName
		HrService hr= (HrService)ctx.getBean(HrService.class); // this is byType
		System.out.println(hr.registerEmployee(1, "hari", "city", 10.8));
	}
	
}
