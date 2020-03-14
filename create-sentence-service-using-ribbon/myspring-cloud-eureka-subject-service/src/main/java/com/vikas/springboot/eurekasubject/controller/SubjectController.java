package com.vikas.springboot.eurekasubject.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {

	@Value("${words}")
	String words;

	@GetMapping("/")
	public @ResponseBody String getRandomSubject() {
		String[] subjectWords = words.split(",");
		int randomIndex = new Random().nextInt(5);
		return subjectWords[randomIndex];
	}

}
