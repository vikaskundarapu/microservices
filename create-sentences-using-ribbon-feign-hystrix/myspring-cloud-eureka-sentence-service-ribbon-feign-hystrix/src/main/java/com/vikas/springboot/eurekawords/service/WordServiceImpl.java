package com.vikas.springboot.eurekawords.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vikas.springboot.eurekawords.dao.AdjectiveClient;
import com.vikas.springboot.eurekawords.dao.ArticleClient;
import com.vikas.springboot.eurekawords.dao.NounClient;
import com.vikas.springboot.eurekawords.dao.SubjectClient;
import com.vikas.springboot.eurekawords.dao.VerbClient;
import com.vikas.springboot.eurekawords.domain.Word;

@Service
public class WordServiceImpl implements WordService {

	@Autowired
	VerbClient verbClient;
	@Autowired
	SubjectClient subjectClient;
	@Autowired
	ArticleClient articleClient;
	@Autowired
	AdjectiveClient adjectiveClient;
	@Autowired
	NounClient nounClient;

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackSubject")
	public Word getSubject() {
		return subjectClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackVerb")
	public Word getVerb() {
		return verbClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackArticle")
	public Word getArticle() {
		return articleClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackNoun")
	public Word getNoun() {
		return nounClient.getWord();
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackAdjective")
	public Word getAdjective() {
		return adjectiveClient.getWord();
	}

	public Word getFallbackSubject() {
		return new Word("Someone");
	}

	public Word getFallbackVerb() {
		return new Word("yearing");
	}

	public Word getFallbackArticle() {
		return new Word("GenericArticle");
	}

	public Word getFallbackNoun() {
		return new Word("something");
	}

	public Word getFallbackAdjective() {
		return new Word("");
	}

}
