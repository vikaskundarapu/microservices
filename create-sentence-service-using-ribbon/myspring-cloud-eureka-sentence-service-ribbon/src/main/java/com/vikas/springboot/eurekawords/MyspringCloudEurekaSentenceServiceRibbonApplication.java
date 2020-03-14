package com.vikas.springboot.eurekawords;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MyspringCloudEurekaSentenceServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringCloudEurekaSentenceServiceRibbonApplication.class, args);
	}

	/*
	 * This "LoadBalanced" RestTemplate is automatically hooked into Ribbon:
	 */
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
