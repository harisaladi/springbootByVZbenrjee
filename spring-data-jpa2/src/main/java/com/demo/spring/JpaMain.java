package com.demo.spring;



import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.service.HrService;

public class JpaMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(DaoConfig.class);
		HrService hrs = ctx.getBean(HrService.class);
		
		//hrs.displayEmpInfo(1119); 
		
		//System.out.println(hrs.registerEmployee(1019, "ur name", "ur city", 100000));
		
	//	hrs.getAllEmployees();
		
		hrs.getSalRanges();
	}

}
