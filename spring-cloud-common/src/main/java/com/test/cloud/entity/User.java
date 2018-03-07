package com.test.cloud.entity;

import java.io.Serializable;
import java.math.BigInteger;
import io.swagger.annotations.ApiModelProperty;
public class User implements Serializable {

    @ApiModelProperty(value="用户id")
    private BigInteger userId;
    @ApiModelProperty(value="用户名")
    private String username;
    @ApiModelProperty(value="用户密码")
    private  String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
}
