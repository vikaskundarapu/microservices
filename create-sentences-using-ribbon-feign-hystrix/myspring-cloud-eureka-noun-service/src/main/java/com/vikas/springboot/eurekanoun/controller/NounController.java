package com.vikas.springboot.eurekanoun.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.springboot.eurekanoun.domain.Word;

@RestController
public class NounController {

	@Value("${words}")
	String[] words;

	@GetMapping("/")
	public Word getRandomNoun() {
		int randomIndex = new Random().nextInt(5);
		return new Word(words[randomIndex]);
	}

}
