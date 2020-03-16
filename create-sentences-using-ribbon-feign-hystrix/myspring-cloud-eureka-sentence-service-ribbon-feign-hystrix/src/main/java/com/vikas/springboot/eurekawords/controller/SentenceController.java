package com.vikas.springboot.eurekawords.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vikas.springboot.eurekawords.service.SentenceService;

@RestController
public class SentenceController {

	@Autowired
	SentenceService sentenceService;

	/**
	 * Display a small list of Sentences to the caller:
	 */
	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
		
		long startTime = System.nanoTime();
		String output = "<h3>Some Sentences</h3><br/>" + sentenceService.buildSentence() + "<br/><br/>"
				+ sentenceService.buildSentence() + "<br/><br/>" + sentenceService.buildSentence() + "<br/><br/>"
				+ sentenceService.buildSentence() + "<br/><br/>" + sentenceService.buildSentence() + "<br/><br/>";
		long endTime = System.nanoTime();
		return output + "Elapsed time (ms): " + ((endTime - startTime) / 1000);
	}
}
