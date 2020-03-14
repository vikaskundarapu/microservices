package com.vikas.springboot.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyspringCloudEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringCloudEurekaServerApplication.class, args);
	}

}
