package com.test.cloud.controller;

import com.test.cloud.entity.User;
import com.test.cloud.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(@PathVariable Integer id, HttpServletRequest request) {
        String res = "拿到数字" + id+"端口号"+request.getRequestURL().toString();
        return res;
    }
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@PathVariable String name, HttpServletRequest request) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        String res = "欢迎" + name+"端口号"+request.getRequestURL().toString();
        return res;
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable Integer id, HttpServletRequest request) {
        User user =null;
        user = userService.queryUserList();
        System.out.println("获取用户信息成功"+id);
        return user;
    }
}

