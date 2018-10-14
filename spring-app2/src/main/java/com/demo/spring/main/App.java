package com.demo.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.service.HRService;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		HRService hr= (HRService)ctx.getBean("hrService");
		System.out.println(hr.registerEmployee(1, "hari", "city", 10.8));
	}
	
}
