package com.test.cloud.service.impl;

import com.test.cloud.entity.User;
import com.test.cloud.mapper.UserMapper;
import com.test.cloud.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    public User queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public void insert() {
        userMapper.insert();
    }

    @Override
    @Transactional
    public void testInsert() {
        userMapper.insert();
        List<String> list = new ArrayList<>();
        list=null;
        list.add("abc");
    }
}
