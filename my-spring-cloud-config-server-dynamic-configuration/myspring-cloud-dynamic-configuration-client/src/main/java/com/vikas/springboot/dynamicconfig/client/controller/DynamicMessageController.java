package com.vikas.springboot.dynamicconfig.client.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "message-config")
public class DynamicMessageController {

	String message;
	String salutation;

	@GetMapping("/message")
	public String getMessage() {
		return salutation + "\n " + message;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
