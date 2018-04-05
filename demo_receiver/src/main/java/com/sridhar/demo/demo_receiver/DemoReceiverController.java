package com.sridhar.demo.demo_receiver;

import org.springframework.web.bind.annotation.GetMapping;

public class DemoReceiverController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
