package com.vikas.springboot.eurekaarticle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MyspringCloudEurekaArticleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringCloudEurekaArticleServiceApplication.class, args);
	}

}
