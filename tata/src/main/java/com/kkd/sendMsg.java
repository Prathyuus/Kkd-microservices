package com.kkd;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sendMsg {
	
	@Autowired
	private AmqpTemplate amqp;
	
	public void genMsg(String msg) {
		amqp.convertAndSend(TataApplication.EXCHANGE_NAME, TataApplication.ROUTING_KEY, msg);
		System.out.println("Send msg = " + msg);
	}
	
}
