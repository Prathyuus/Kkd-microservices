package com.sridhar.demo.demo_receiver;

import java.io.IOException;

import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class DemoReceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoReceiverApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler()
	{
	return Sampler.ALWAYS_SAMPLE;
	}
	@Bean
	public Docket api() throws IOException, XmlPullParserException {
		return new Docket(DocumentationType.SWAGGER_2);
	}

}
