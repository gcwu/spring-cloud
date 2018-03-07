package com.test.cloud.mapper;

import com.test.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User queryUserList();
}
