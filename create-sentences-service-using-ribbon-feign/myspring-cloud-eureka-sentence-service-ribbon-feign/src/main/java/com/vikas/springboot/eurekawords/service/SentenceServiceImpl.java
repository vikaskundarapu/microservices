package com.vikas.springboot.eurekawords.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikas.springboot.eurekawords.dao.AdjectiveClient;
import com.vikas.springboot.eurekawords.dao.ArticleClient;
import com.vikas.springboot.eurekawords.dao.NounClient;
import com.vikas.springboot.eurekawords.dao.SubjectClient;
import com.vikas.springboot.eurekawords.dao.VerbClient;

/**
 * Build a sentence by assembling randomly generated subjects, verbs, articles,
 * adjectives, and nouns. The individual parts of speech will be obtained by
 * calling the various DAOs.
 */
@Service
public class SentenceServiceImpl implements SentenceService {

	private VerbClient verbService;
	private SubjectClient subjectService;
	private ArticleClient articleService;
	private AdjectiveClient adjectiveService;
	private NounClient nounService;

	@Autowired
	public void setVerbService(VerbClient verbService) {
		this.verbService = verbService;
	}

	@Autowired
	public void setSubjectService(SubjectClient subjectService) {
		this.subjectService = subjectService;
	}

	@Autowired
	public void setArticleService(ArticleClient articleService) {
		this.articleService = articleService;
	}

	@Autowired
	public void setAdjectiveService(AdjectiveClient adjectiveService) {
		this.adjectiveService = adjectiveService;
	}

	@Autowired
	public void setNounService(NounClient nounService) {
		this.nounService = nounService;
	}

	@Override
	public String buildSentence() {
		String sentence = "There was a problem assembling the sentence!";
		sentence = String.format("%s %s %s %s %s.", subjectService.getWord().getString(),
				verbService.getWord().getString(), articleService.getWord().getString(),
				adjectiveService.getWord().getString(), nounService.getWord().getString());
		return sentence;
	}

}
