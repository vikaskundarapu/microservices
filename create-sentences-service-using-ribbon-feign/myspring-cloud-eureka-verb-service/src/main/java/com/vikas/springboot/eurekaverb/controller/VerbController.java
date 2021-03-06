package com.vikas.springboot.eurekaverb.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.springboot.eurekaverb.domain.Word;

@RestController
public class VerbController {

	@Value("${words}")
	String[] words;

	@GetMapping("/")
	public Word getRandomVerb() {
		int randomIndex = new Random().nextInt(5);
		return new Word(words[randomIndex]);
	}

}
