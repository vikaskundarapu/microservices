package com.vikas.springboot.eurekaverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyspringCloudEurekaVerbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringCloudEurekaVerbServiceApplication.class, args);
	}

}
