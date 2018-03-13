package com.test.cloud.demo.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import com.test.cloud.common.util.ResultUtil;
import com.test.cloud.demo.service.DemoService;
import com.test.cloud.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "DemoController", description = "测试用例")
@RestController
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    private DemoService demoService;

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @GetMapping("/getUser")
    @ResponseBody
    public String getUser() {
        logger.info("--->调用/getUser成功");
        User result = demoService.getUser(123);
        return JSON.toJSONString(ResultUtil.success(result));
    }
}
