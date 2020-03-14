package com.vikas.springboot.eurekawords.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

	@Autowired
	RestTemplate template;

	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
		return getWord("eureka-subject") + " " + getWord("eureka-verb") + " " + getWord("eureka-article") + " "
				+ getWord("eureka-adjective") + " " + getWord("eureka-noun") + ".";
	}

	private String getWord(String service) {
		return template.getForObject("http://" + service, String.class);
	}
}
