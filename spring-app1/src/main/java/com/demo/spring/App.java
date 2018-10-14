package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext appContext=new ClassPathXmlApplicationContext("context.xml");
		
		Mail mail = (Mail) appContext.getBean("mail");

		System.out.println(mail.getMessage().getBody());
	}

}
