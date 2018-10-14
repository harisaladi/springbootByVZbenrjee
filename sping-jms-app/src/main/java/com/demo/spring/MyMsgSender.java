package com.demo.spring;

import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MyMsgSender {

	public static void main(String[] args) {
		
		ApplicationContext ctx= new AnnotationConfigApplicationContext(JmsConfig.class);
		//JmsTemplate jt =ctx.getBean(JmsTemplate.class); // for queue

		JmsTemplate jtPubSub =(JmsTemplate)ctx.getBean("jtPubSub");
		// without lambda
		/*jt.send("testQueue",new MessageCreator(){

			@Override
			public Message createMessage(Session session) throws JMSException {
				
				TextMessage msg=session.createTextMessage();
				msg.setText("Hii");
				return msg;
			}
	});*/
		
		for (int i=0; i <10;i++) {
		//with Lambda
			int count =i;
			//jt.send("testQueue",(session) -> {	-- for queue		
			jtPubSub.send("demoTopic",(session) -> {	
			TextMessage msg=session.createTextMessage();
			msg.setText("message:"+count);
			System.out.println("Message sent...message:"+count);
			//count++;
			return msg;
			
		});
		
		}
		
		//System.out.println("Message sent...");
	}

}
