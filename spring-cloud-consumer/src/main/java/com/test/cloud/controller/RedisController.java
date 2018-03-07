package com.test.cloud.controller;

import com.test.cloud.entity.User;
import com.test.cloud.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@Api(value = "RedisController", description = "Redis测试用例")
@RequestMapping("/redis")
@RestController
public class RedisController {

    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);



}
