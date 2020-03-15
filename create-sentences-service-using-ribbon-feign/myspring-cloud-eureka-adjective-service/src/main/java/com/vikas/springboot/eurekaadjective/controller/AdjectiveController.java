package com.vikas.springboot.eurekaadjective.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.springboot.eurekaadjective.domain.Word;

@RestController
public class AdjectiveController {

	@Value("${words}")
	String[] words;

	@GetMapping("/")
	public Word getRandomAdjective() {
		int randomIndex = new Random().nextInt(5);
		return new Word(words[randomIndex]);
	}

}
