package com.vikas.springboot.eurekasubject.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.springboot.eurekasubject.domain.Word;

@RestController
public class SubjectController {

	@Value("${words}")
	String[] words;

	@GetMapping("/")
	public Word getRandomSubject() {
		int randomIndex = new Random().nextInt(5);
		return new Word(words[randomIndex]);
	}

}
