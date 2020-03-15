package com.vikas.springboot.eurekawords.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.vikas.springboot.eurekawords.domain.Word;

@FeignClient("eureka-verb")
public interface VerbClient {
	
	@GetMapping("/")
	public Word getWord();
}
