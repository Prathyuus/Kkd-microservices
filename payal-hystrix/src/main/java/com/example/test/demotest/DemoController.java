package com.example.test.demotest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DemoController {
	
	@GetMapping("/hello")
	@HystrixCommand(fallbackMethod="demofallback")
	public String hello()
	{
		throw new RuntimeException();
	}
	public String demofallback()
	{
		return "new fallback";
	}
}
