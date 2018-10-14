package com.demo.spring;

//import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class AudienceAround {

	public void buyTickets() {
		System.out.println("buy tickets");
	}
	public void exit() {
		System.out.println("exit");
	}
	@Pointcut("execution(* com.demo.spring.Performer.perform(..))")
	public void pcut() {
		
	}
	
	@Around("pcut()")
	public void invoke(ProceedingJoinPoint pjp)throws Throwable{
		buyTickets();
		pjp.proceed();
		exit();
	}
}
