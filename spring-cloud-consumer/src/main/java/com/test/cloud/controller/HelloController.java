package com.test.cloud.controller;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.test.cloud.entity.User;
import com.test.cloud.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api(value = "HelloController", description = "测试用例")
@RestController
public class HelloController {
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Autowired
	private HelloService helloService;
	@ApiOperation(value="hello", notes="hello")
	@GetMapping("/hello")
	@ResponseBody
	public String hello() throws Exception{
		String result = helloService.hello("hello");
		HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
				.getInstance(HystrixCommandKey.Factory
						.asKey("HelloService#hello(String)"));
		System.out.println("断路器状态" + breaker.isOpen());
		return result;
	}

	@GetMapping("/hello/test1")
	@ResponseBody
	@ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
	public User test1() {
		logger.info("--->调用/hello/test1成功");
		User result = helloService.getUser(123);
		return result;
	}
}
