package com.vikas.springboot.dynamicconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MyspringCloudDynamicConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyspringCloudDynamicConfigurationApplication.class, args);
	}

}
