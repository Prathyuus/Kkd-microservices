package com.kkd;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TataController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private sendMsg msgToRabbit;
	
	@HystrixCommand(fallbackMethod = "trialfb")
	@GetMapping("/test") // mapping to test method
	public String testMethod() { // method to test the trial, send logger msg
		logger.info("{}", "Test Trial");
		if (RandomUtils.nextBoolean()) {
			throw new RuntimeException("Failed loading Test Trial");
		}
		return "Test Trial";
	}
	
	
	public String trialfb() {
		return "Fallback for Test Trial";
	}
	
	@RequestMapping("/send")
	public String sendMsg(){
		String msg="sending";
		logger.info("Sending message...");
		msgToRabbit.genMsg(msg);
		return "Done";
	}
		
}
