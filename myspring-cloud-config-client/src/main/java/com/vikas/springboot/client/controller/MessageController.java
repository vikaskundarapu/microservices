package com.vikas.springboot.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	/*the below property comes from server configuration file that we have kept on Github*/
	@Value("${message}")
	String message;
	
	@GetMapping("/message")
	public String getMessage() {
		return "Today's message is: "+message;
	}
	
}
