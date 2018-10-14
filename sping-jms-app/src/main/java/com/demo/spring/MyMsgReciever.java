package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MyMsgReciever {

	public static void main(String[] args) throws JMSException {
		
		ApplicationContext ctx= new AnnotationConfigApplicationContext(JmsConfig.class);
		//JmsTemplate jt =ctx.getBean(JmsTemplate.class); // for queue
		JmsTemplate jt =(JmsTemplate)ctx.getBean("jtPubSub"); //for topic
		

		// without lambda
		/*jt.send("testQueue",new MessageCreator(){

			@Override
			public Message createMessage(Session session) throws JMSException {
				
				TextMessage msg=session.createTextMessage();
				msg.setText("Hii");
				return msg;
			}
	});*/
		//with Lambda
	//	TextMessage msg= (TextMessage)jt.receive("testQueue");
		TextMessage msg= (TextMessage)jt.receive("demoTopic");
			
		System.out.println(msg.getText());
			
	
	}

}
