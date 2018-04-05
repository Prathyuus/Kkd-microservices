package com.farmer.farmerloginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableEurekaDiscovery
@EnableConfigServer                               
@EnableSwagger2
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
public class FarmerLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmerLoginServiceApplication.class, args);
	}
//	//for sleuth to generate id
//		@Bean
//		public Sampler defaultSampler(){
//			return Sampler.ALWAYS_SAMPLE;
//		}
//		//creating exchange
//		@Bean
//		public TopicExchange appExchange() {
//			return new TopicExchange(EXCHANGE_NAME);
//		}
//
//		//creating generic queue
//		@Bean
//		public Queue appQueueGeneric() {
//			return new Queue(QUEUE_GENERIC_NAME);
//		}
//		//creating specific queue
//		@Bean
//		public Queue appQueueSpecific() {
//			return new Queue(QUEUE_SPECIFIC_NAME);
//		}
//
//		//binding generic queue with exchange with a routing key
//		@Bean
//		public Binding declareBindingGeneric() {
//			return BindingBuilder.bind(appQueueGeneric()).to(appExchange()).with(ROUTING_KEY);
//		}
//
//		//binding specific queue with exchange with a routing key
//		@Bean
//		public Binding declareBindingSpecific() {
//			return BindingBuilder.bind(appQueueSpecific()).to(appExchange()).with(ROUTING_KEY);
//		}
		
		//For swagger to document the Service
		@Bean
		public Docket api() throws IOException, XmlPullParserException {
			return new Docket(DocumentationType.SWAGGER_2);
		}
}
