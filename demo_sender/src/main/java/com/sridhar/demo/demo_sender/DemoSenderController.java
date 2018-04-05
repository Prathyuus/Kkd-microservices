package com.sridhar.demo.demo_sender;





import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;





public class DemoSenderController {
private DemoSenderProxy proxy;
private Logger logger = LoggerFactory.getLogger(this.getClass());

//using messege sender service to send message to rabbitmq
@Autowired
private MessageSender sendMessageToRabbit;

	@HystrixCommand(fallbackMethod="fallback")
	@GetMapping("/hello")
	public String hello() {
	  
	   if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("Failed loadin Bye");
		}
	   return proxy.hello();
	}
	
	public String fallback() {
		return "fallback for demo sender service";
	}
	
	//a demo mapping to send msg
		@RequestMapping("/send/{msg}")
		public String sendMsg( @PathVariable String msg){
			String msg1=msg;
			logger.info("Sending message...");
			sendMessageToRabbit.produceMsg(msg1);
			return "Done";
		}
			
}
