package com.vikas.springboot.eurekawords.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vikas.springboot.eurekawords.domain.Word;

@FeignClient("eureka-adjective")
public interface AdjectiveClient {

	@GetMapping("/")
	public Word getWord();
	

}
