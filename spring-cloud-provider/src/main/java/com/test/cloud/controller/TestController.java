package com.test.cloud.controller;

import com.test.cloud.entity.User;
import com.test.cloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    private UserService userService;

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(@PathVariable Integer id, HttpServletRequest request)  throws Exception{
        String res = "拿到数字" + id+"端口号"+request.getRequestURL().toString();
        logger.info("---->success{}",res);

        return res;
    }
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@PathVariable String name, HttpServletRequest request) throws Exception{
        userService.testInsert();
        return "ok";
    }
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable Integer id, HttpServletRequest request) {
        User user =null;
        user = userService.queryUserList();
        logger.info("---->获取用户信息成功");
        return user;
    }
}

