package com.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.entity.domain.SysMapRoleResource;
import com.common.entity.domain.SysMapUserRole;
import com.system.service.SysMapRoleResourceService;
import com.system.service.SysMapUserRoleService;
import com.test.cloud.entity.User;
import com.test.cloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class TestsController {
    private static final Logger logger = LoggerFactory.getLogger(TestsController.class);
    @Resource
    private UserService userService;
    @Resource
    private SysMapUserRoleService sysMapUserRoleService;
    @RequestMapping(value = "/sys/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public String sys(@PathVariable Integer id, HttpServletRequest request) {
        List<SysMapUserRole>list= sysMapUserRoleService.findAll();
        logger.info("---->success{}", JSONObject.
            
            toJSON(list));
        String res = "拿到数字" + id+"端口号"+request.getRequestURL().toString();
        logger.info("---->success{}",res);
        return JSONObject.toJSON(list).toString();
    }


    @RequestMapping(value = "/test1/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String test(@PathVariable Integer id, HttpServletRequest request) {
        String res = "拿到数字" + id+"端口号"+request.getRequestURL().toString();
        logger.info("---->success{}",res);
        return res;
    }
    @RequestMapping(value = "/hello1/{name}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello(@PathVariable String name, HttpServletRequest request) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        String res = "欢迎" + name+"端口号"+request.getRequestURL().toString();
        return res;
    }
    @RequestMapping(value = "/getUser1/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable Integer id, HttpServletRequest request) {
        User user =null;
        user = userService.queryUserList();
        logger.info("---->获取用户信息成功");
        return user;
    }
}

