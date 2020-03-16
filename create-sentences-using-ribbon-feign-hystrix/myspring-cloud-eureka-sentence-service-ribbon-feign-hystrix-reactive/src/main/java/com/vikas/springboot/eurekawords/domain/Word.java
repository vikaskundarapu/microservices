package com.vikas.springboot.eurekawords.domain;

import com.vikas.springboot.eurekawords.domain.Word.Role;

/**
 * 'Word' object is nicely represented in JSON over a regular String.
 */
public class Word {

	public static enum Role {
		SUBJECT, VERB, ARTICLE, ADJECTIVE, NOUN;
	}

	public String word;
	public Role role;

	public Word() {
		super();
	}

	public Word(String word) {
		this();
		this.word = word;
	}
	
	public Word(String word, Role role) {
		this(word);
		this.role = role;
	}

	public String getWord() {
		return word;
	}

	public String getString() {
		return getWord();
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
