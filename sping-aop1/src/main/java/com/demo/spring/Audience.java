package com.demo.spring;

//import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Audience {

	@Pointcut("execution(* com.demo.spring.Performer.perform(..))")
	public void pcut() {
		
	}
	
	//@Before("execution(* com.demo.spring.Performer.perform(..))")
	@Before("pcut()")
	public void takeSeat() {
		System.out.println("Audience taking seats");
	}
	
	//@Before("execution(* com.demo.spring.Performer.perform(..))")
	@Before("pcut()")
	public void switchoff() {
		System.out.println("Audience switch off mobiles");
	}
	//@AfterReturning("execution(* com.demo.spring.Performer.perform(..))")
	@AfterReturning("pcut()")
	public void applaud() {
		System.out.println("claps.. Good singing");
	}
}
