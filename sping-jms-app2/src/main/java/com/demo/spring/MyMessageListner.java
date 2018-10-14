package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MyMessageListner {

	//@JmsListener(destination="testQueue" , containerFactory="factory") // this is bean name
	@JmsListener(destination="demoTopic" , containerFactory="factory") // this is bean name
	public void receive(Message msg) throws JMSException {
		
		TextMessage tm=(TextMessage)msg;
		
		System.out.println(tm.getText());
		
	}
}
