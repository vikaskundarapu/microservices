package com.vikas.springboot.eurekawords.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.vikas.springboot.eurekawords.domain.Word;

@FeignClient("eureka-subject")
public interface SubjectClient {
	
	@GetMapping("/")
	public Word getWord();
}
