package com.test.cloud.service;

import com.alibaba.fastjson.JSON;
import com.test.cloud.common.util.ResultUtil;
import com.test.cloud.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class HelloServiceFallback implements HelloService {
    public String hello(String name) {
        System.out.println("-----hello Fallback");
        return JSON.toJSONString(ResultUtil.systemError());
    }

    public User getUser(Integer id) {
        System.out.println("-----getUser Fallback");
        return new User();
    }
}
