package com.vikas.springboot.eurekasentence.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

	@Autowired
	DiscoveryClient client;

	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
		return getWord("eureka-subject") + " " + getWord("eureka-verb") + " " + getWord("eureka-article") + " "
				+ getWord("eureka-adjective") + " " + getWord("eureka-noun") + ".";
	}

	private String getWord(String service) {

		List<ServiceInstance> instances = client.getInstances(service);

		if (Objects.nonNull(instances) && !instances.isEmpty()) {
			URI uri = instances.get(0).getUri();

			if (Objects.nonNull(uri)) {
				return new RestTemplate().getForObject(uri, String.class);
			}
		}

		return null;
	}

}
