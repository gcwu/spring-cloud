package com.test.cloud.controller;

import com.sun.net.httpserver.HttpServer;
import org.springframework.http.HttpRequest;
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
}

