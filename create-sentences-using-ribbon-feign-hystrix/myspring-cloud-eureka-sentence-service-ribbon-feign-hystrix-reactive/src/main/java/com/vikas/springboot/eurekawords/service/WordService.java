package com.vikas.springboot.eurekawords.service;

import com.vikas.springboot.eurekawords.domain.Word;

import rx.Observable;

public interface WordService {

	Observable<Word> getSubject();

	Observable<Word> getVerb();

	Observable<Word> getArticle();

	Observable<Word> getAdjective();

	Observable<Word> getNoun();

}
