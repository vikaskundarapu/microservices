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
import com.vikas.springboot.eurekawords.domain.Word.Role;

import rx.Observable;

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

	/*
	 * The 'reactive' observable is backed by a regular Java Callable, which can run
	 * in a different thread. We have created a Callable which returns the word
	 * object with both "role" and "word" state.
	 */
	@Override
	@HystrixCommand(fallbackMethod = "getFallbackSubject")
	public Observable<Word> getSubject() {
		return Observable.fromCallable(() -> new Word(subjectClient.getWord().getString(), Role.SUBJECT));
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackVerb")
	public Observable<Word> getVerb() {
		return Observable.fromCallable(() -> new Word(verbClient.getWord().getString(), Role.VERB));
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackArticle")
	public Observable<Word> getArticle() {
		return Observable.fromCallable(() -> new Word(articleClient.getWord().getString(), Role.ARTICLE));
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackNoun")
	public Observable<Word> getNoun() {
		return Observable.fromCallable(() -> new Word(nounClient.getWord().getString(), Role.NOUN));
	}

	@Override
	@HystrixCommand(fallbackMethod = "getFallbackAdjective")
	public Observable<Word> getAdjective() {
		return Observable.fromCallable(() -> new Word(adjectiveClient.getWord().getString(), Role.ADJECTIVE));
	}

	public Observable<Word> getFallbackSubject() {
		return Observable.fromCallable(() -> new Word("Someone", Role.SUBJECT));
	}

	public Observable<Word> getFallbackVerb() {
		return Observable.fromCallable(() -> new Word("yearing", Role.VERB));
	}

	public Observable<Word> getFallbackArticle() {
		return Observable.fromCallable(() -> new Word("GenericArticle", Role.ARTICLE));
	}

	public Observable<Word> getFallbackNoun() {
		return Observable.fromCallable(() -> new Word("something", Role.NOUN));
	}

	public Observable<Word> getFallbackAdjective() {
		return Observable.fromCallable(() -> new Word("", Role.NOUN));
	}

}
