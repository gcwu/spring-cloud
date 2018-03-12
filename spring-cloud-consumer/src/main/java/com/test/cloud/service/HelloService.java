package com.test.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.test.cloud.common.constant.Constants;


@FeignClient(value = Constants.SYS_PROVIDER_ID,fallback = HelloServiceFallback.class)
public interface HelloService {
    @RequestMapping(method = RequestMethod.GET,value = "/hello/{name}")
    String hello(@PathVariable("name") String name) throws Exception;

    @RequestMapping(method = RequestMethod.GET,value = "/getUser/{id}")
    User getUser(@PathVariable("id") Integer id);
}
