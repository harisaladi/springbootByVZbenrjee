package com.demo.spring;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.service.HrService;

public class JpaMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService hrs = ctx.getBean(HrService.class);
		
		//hrs.displayEmpInfo(1002); 
		
		System.out.println(hrs.registerEmployee(1017, "ur name", "ur city", 100000));
		
		hrs.getAllEmployees();
	}

}
