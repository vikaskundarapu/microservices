package com.vikas.springboot.eurekawords.domain;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.vikas.springboot.eurekawords.domain.Word.Role;

public class Sentence {

	Map<Role, String> words = new TreeMap<>();

	public void add(Word word) {
		words.put(word.getRole(), word.getWord());
	}

	@Override
	public String toString() {
		return words.keySet().stream().map(role -> words.get(role)).collect(Collectors.joining(" "));
	}
}
