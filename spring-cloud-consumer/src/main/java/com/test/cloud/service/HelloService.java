package com.test.cloud.service;

import com.test.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "provider",fallback = HelloServiceFallback.class)
public interface HelloService {
    @RequestMapping(method = RequestMethod.GET,value = "/hello/{name}")
    String hello(@PathVariable("name") String name);

    @RequestMapping(method = RequestMethod.GET,value = "/getUser/{id}")
    User getUser(@PathVariable("id") Integer id);
}
