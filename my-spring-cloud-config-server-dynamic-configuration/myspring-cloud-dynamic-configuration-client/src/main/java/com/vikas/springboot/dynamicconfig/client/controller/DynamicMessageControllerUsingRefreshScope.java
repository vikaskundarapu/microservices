package com.vikas.springboot.dynamicconfig.client.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller demonstrates @RefreshScope alternative
 * to @ConfigurationProperties
 */

@RestController
@RefreshScope
public class DynamicMessageControllerUsingRefreshScope {

	@Value("${message-config.message}")
	String message;
	@Value("${message-config.salutation}")
	String salutation;

	String fullGreeting;
	
	@PostConstruct
	public void init() {
		fullGreeting = "Greeting of the day! /n "+salutation+"\n"+message;
	}
	
	@GetMapping("/messageRefreshScope")
	public String getMessage() {
		return salutation + "\n " + message;
	}

	@GetMapping("/greetings")
	public String getGreeting() {
		return fullGreeting;
	}
}
