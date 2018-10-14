package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Singer implements Performer {

	@Autowired
	private Audience audience;
	
	@Override
	public void perform() {
		
		//audience.takeSeat(); // cross cutting without aop
		//audience.switchoff();//cross cutting without aop
		System.out.println("singing");
		//audience.applaud();//cross cutting  without aop
	}

}
