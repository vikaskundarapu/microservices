package com.vikas.springboot.eurekanoun.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NounController {

	@Value("${words}")
	String words;
	
	@GetMapping("/")
	public @ResponseBody String getRandomNoun() {
		String[] nouns = words.split(",");
		int randomIndex = new Random().nextInt(7);
		return nouns[randomIndex];
	}
	
}
