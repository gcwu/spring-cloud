package com.test.cloud.controller;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.test.cloud.entity.User;
import com.test.cloud.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

	@Resource
	private HelloService helloService;

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		String result = helloService.hello("hello");
		HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
				.getInstance(HystrixCommandKey.Factory
						.asKey("HelloService#hello(String)"));
		System.out.println("断路器状态" + breaker.isOpen());
		return result;
	}

	@GetMapping("/getUser")
	@ResponseBody
	public User getUser() {
		User result = helloService.getUser(123);
		return result;
	}

	@GetMapping("/hello/test1")
	@ResponseBody
	public User test1() {
		User result = helloService.getUser(123);
		return result;
	}
}
