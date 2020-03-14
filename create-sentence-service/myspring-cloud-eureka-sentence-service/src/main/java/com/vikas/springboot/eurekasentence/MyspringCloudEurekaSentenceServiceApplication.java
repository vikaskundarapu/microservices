package com.vikas.springboot.eurekasentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyspringCloudEurekaSentenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringCloudEurekaSentenceServiceApplication.class, args);
	}

}
