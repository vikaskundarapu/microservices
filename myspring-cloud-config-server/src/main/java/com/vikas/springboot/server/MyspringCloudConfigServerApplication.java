package com.vikas.springboot.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MyspringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringCloudConfigServerApplication.class, args);
	}

}
