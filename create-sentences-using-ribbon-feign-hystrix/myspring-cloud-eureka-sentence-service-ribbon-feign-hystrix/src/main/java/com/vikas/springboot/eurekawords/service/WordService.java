package com.vikas.springboot.eurekawords.service;

import com.vikas.springboot.eurekawords.domain.Word;

public interface WordService {

	Word getSubject();

	Word getVerb();

	Word getArticle();

	Word getAdjective();

	Word getNoun();

}
