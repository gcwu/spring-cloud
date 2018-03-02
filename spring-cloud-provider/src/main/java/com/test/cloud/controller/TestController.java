package com.test.cloud.controller;

import com.test.cloud.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(@PathVariable Integer id, HttpServletRequest request) {
        String res = "拿到数字" + id+"端口号"+request.getRequestURL().toString();
        return res;
    }
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@PathVariable String name, HttpServletRequest request) {
        String res = "欢迎" + name+"端口号"+request.getRequestURL().toString();
        return res;
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable Integer id, HttpServletRequest request) {
        User u = new User();
        u.setUserId(id);
        u.setUsername("张三");
        u.setPassword("123456");
        return u;
    }
}

