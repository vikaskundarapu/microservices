package com.vikas.springboot.eurekaarticle.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

	@Value("${words}")
	String words;
	
	@GetMapping("/")
	public @ResponseBody String getRandomArticle() {
		String[] articles = words.split(",");
		int randomIndex = new Random().nextInt(2);
		return articles[randomIndex];
	}
	
}
