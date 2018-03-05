package com.test.cloud.service;

import com.test.cloud.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class HelloServiceFallback implements HelloService {
    public String hello(String name) {
        System.out.println("-----hello Fallback");
        return "服务已断开";
    }

    public User getUser(Integer id) {
        System.out.println("-----getUser Fallback");
        return new User();
    }
}
