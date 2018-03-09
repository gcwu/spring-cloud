package com.test.cloud.service.impl;

import com.test.cloud.entity.User;
import com.test.cloud.mapper.UserMapper;
import com.test.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    public User queryUserList() {
        return userMapper.queryUserList();
    }
}
