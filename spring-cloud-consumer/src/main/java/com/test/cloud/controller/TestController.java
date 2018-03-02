package com.test.cloud.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Configuration
public class TestController {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@GetMapping("/test")
	@ResponseBody
	public String router() {
		RestTemplate tpl = getRestTemplate();
		String json = tpl.getForObject("http://provider/test/1", String.class);
		return json;
	}

}
