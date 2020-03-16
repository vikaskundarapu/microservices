package com.vikas.springboot.eurekasubject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyspringCloudEurekaSubjectServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringCloudEurekaSubjectServiceApplication.class, args);
	}

}
