package com.vikas.springboot.eurekawords.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.springboot.eurekawords.domain.Sentence;
import com.vikas.springboot.eurekawords.domain.Word;

import rx.Observable;

/**
 * Build a sentence by assembling randomly generated subjects, verbs, articles,
 * adjectives, and nouns. The individual parts of speech will be obtained by
 * calling the various DAOs.
 */
@Service
public class SentenceServiceImpl implements SentenceService {

	@Autowired
	WordService wordService;

	/**
	 * Assemble a sentence by gathering random words of each part of speech:
	 */
	@Override
	public String buildSentence() {
		Sentence sentence = new Sentence();

		/*
		 * Launch calls to all child services, using Observables to handle the responses
		 * from each one.
		 */
		List<Observable<Word>> observables = createObservables();

		/* Use a CountDownLatch to detect when ALL of the calls are complete. */
		CountDownLatch latch = new CountDownLatch(observables.size());

		/*
		 * Merging all the observables into one observer, so we can add a common
		 * subscriber. This subscribe() call will add a word to the sentence object once
		 * it is completed. We also decrement the CountDownLatch.
		 */
		Observable.merge(observables).subscribe((word) -> {
			sentence.add(word);
			latch.countDown();
		});

		waitForAll(latch);

		return sentence.toString();
	}

	/**
	 * Ultimately, we will need to wait for all 5 calls to be completed before the
	 * sentence can be assembled. This code waits for the last call to come back:
	 */
	private void waitForAll(CountDownLatch latch) {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private List<Observable<Word>> createObservables() {
		List<Observable<Word>> observables = new ArrayList<>();
		observables.add(wordService.getSubject());
		observables.add(wordService.getVerb());
		observables.add(wordService.getArticle());
		observables.add(wordService.getAdjective());
		observables.add(wordService.getNoun());
		return observables;
	}

}
