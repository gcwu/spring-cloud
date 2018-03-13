package com.test.cloud.demo.service;

import com.test.cloud.common.constant.Constants;
import com.test.cloud.demo.service.fallback.DemoServiceFallback;
import com.test.cloud.entity.User;
import com.test.cloud.service.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = Constants.SYS_PROVIDER_ID,fallback = DemoServiceFallback.class)
public interface DemoService {
    @RequestMapping(method = RequestMethod.GET,value = "/getUser/{id}")
    User getUser(@PathVariable("id") Integer id);
}
