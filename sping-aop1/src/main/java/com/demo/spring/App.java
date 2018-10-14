package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx= new AnnotationConfigApplicationContext(AopConfig.class);
		Performer performer= (Performer)ctx.getBean("singer");
		performer.perform();
		//System.out.println(performer.getClass().getName());
		/*// to know the interfaces implemented the singer class - proxies
		Class<?>[] interfaces=performer.getClass().getInterfaces();
		for (Class<?> c:interfaces)
		System.out.println(c.getName());*/
	}

}
