package com.sridhar.demo.demo_sender;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="demo_receiver")
@RibbonClient(name="demo_receiver")
public interface DemoSenderProxy {
	@GetMapping("/hello")
	public String hello();
}
