package com.farmer.farmerloginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@EnableFeignClients("com.farmer.farmerloginservice")
public class FarmerLoginController {

	@Autowired
	private FeignProxy proxy;
	
	@HystrixCommand(fallbackMethod="fallback")
	@PostMapping("/login")
	public void getData() {
		
	}
	void fallback() {
		
	}
	
}
